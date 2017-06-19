/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repsplitacc;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bmr
 */
public class ConexaoBanco {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public boolean conectar(){       
        try {
    	
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException ex) { 
            System.out.println("Problema no Oracle Driver");
            System.out.println(ex);
            return false;
        }
            
         try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "usuario08",
                    "usuario08");
            System.out.println("Conectado");
            return true;
        } catch (SQLException ex) { 
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema: verifique seu usuário e senha");
        }
        return false;
    }

    public boolean AutenticaUsuario(String Name, String password){
        String auten = "";
        String usuario = null;
        String senha = null;
        
        try {
            
            auten = "SELECT login, senha FROM USUARIO WHERE login = '" + Name + "' and senha = '" + password + "'";
                        
            stmt = connection.createStatement();
            rs = stmt.executeQuery(auten);
            
            while (rs.next()) {
                //System.out.println(rs.getString("login") + "-" + rs.getString("senha"));
                usuario = rs.getString("login");
                senha = rs.getString("senha");
            }            
            
            
        } catch (SQLException ex) {
            System.out.println("Erro na consulta");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usuario == null || senha == null){
            return false;
        }
        else if(usuario.compareTo(Name) == 0 && senha.compareTo(password) == 0){
            return true;
        }
        return false;
    }
    
    public ArrayList<ArrayList<String>> DespesasDoGrupo(int Grupo_ID){
        ArrayList<ArrayList<String>> List = new ArrayList<ArrayList<String>>();
        ArrayList<String> Linha;
        int value;
        double preco;
        
        String auten = "";
        
        try {
            
            auten = "SELECT * FROM DESPESA WHERE ID_GRUPO = " + Grupo_ID;
                        
            stmt = connection.createStatement();
            rs = stmt.executeQuery(auten);
            
            while (rs.next()) {
                Linha = new ArrayList<String>();
                value = rs.getInt("ID_DESPESA");
                Linha.add(String.valueOf(value));
                Linha.add(rs.getString("RAZAO"));
                preco = rs.getDouble("VALOR");
                Linha.add(String.valueOf(preco));
                Linha.add(rs.getString("DATA_HORA"));
                value = rs.getInt("ID_GRUPO");
                Linha.add(String.valueOf(value));
                value = rs.getInt("ID_USUARIO");
                Linha.add(String.valueOf(value));
                List.add(Linha);
                
            }            
        } catch (SQLException ex) {
            System.out.println("Erro na consulta ou na Lista");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return List;
    }
    
    public ArrayList<String> GruposUsuario(String usuarioID){
        ArrayList<String> List = new ArrayList<String>();
        String auten = "";
        int value;
        
       // int aux = Integer.parseInt(usuarioID);
        int aux = Integer.valueOf(usuarioID);
        
        try {
            
            auten = "SELECT id_grupo FROM USUARIO_GRUPO WHERE id_usuario = " + aux;
                        
            stmt = connection.createStatement();
            rs = stmt.executeQuery(auten);
            
            while (rs.next()) {
                value = rs.getInt("id_grupo");
                List.add(String.valueOf(value));
            }                        
        } catch (SQLException ex) {
            System.out.println("Erro na consulta");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    }
    
    public boolean InserirUsuario(String Nome, String Login, String Senha){
        String insere = "";
        
        try {
            insere = "insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('" + Nome + "', '" + Login + "', '" + Senha + "', USUARIO_seq.nextval)";
                        
            stmt = connection.createStatement();
            stmt.executeUpdate(insere);
            
            /*commit(); */
            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro na inserção do usuario"); 
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean InserirDespesa(String Razao, double Valor, int id_grupo, int id_usuario){
    
        /*insert into DESPESA (id_despesa, razao, valor, id_grupo, id_usuario) values ('1', 'agua', 23.0, '100', '1');*/
        String insere = "";
        
        try {
            insere = "insert into DESPESA (id_despesa, razao, valor, id_grupo, id_usuario) values (DESPESA_seq.nextval, '" + Razao + "', " + Valor + ", " + id_grupo + ", " + id_usuario + ")";
                        
            stmt = connection.createStatement();
            stmt.executeUpdate(insere);
            
            /*commit(); */
            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro na inserção da despesa");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return false;
    }
    
    public boolean CriarGrupo(int usuarioIDadmin, String NomeGrupo){
        String insere = "";
        
        /*insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Never', '100', '1');*/
        
        try {
            insere = "insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('" + NomeGrupo + "', GRUPO_seq.nextval," + usuarioIDadmin + ")";
                        
            stmt = connection.createStatement();
            stmt.executeUpdate(insere);
            
            /*commit(); */
            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro na inserção do Grupo");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean RelacaoUsuarioGrupo(int usuarioID, int grupoID){
        String insere = "";
        
        /*insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values ('1', '1', '100');*/
        
        try {
            insere = "insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (USUARIO_GRUPO_seq.nextval, " + usuarioID + ", " + grupoID + ")";
                        
            stmt = connection.createStatement();
            stmt.executeUpdate(insere);
            
            /*commit(); */
            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro na inserção da Relação grupo usuario");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void FechaBD(){
        try {
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao fechar o BD");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
