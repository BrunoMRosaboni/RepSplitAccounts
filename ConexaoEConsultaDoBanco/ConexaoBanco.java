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
    
    public ArrayList<ArrayList<String>> DespesasDoGrupo(String Grupo_ID){
        ArrayList<ArrayList<String>> List = new ArrayList<ArrayList<String>>();
        ArrayList<String> Linha;
        
        String auten = "";
        
        try {
            
            auten = "SELECT * FROM DESPESA WHERE ID_GRUPO = '" + Grupo_ID + "'";
                        
            stmt = connection.createStatement();
            rs = stmt.executeQuery(auten);
            
            while (rs.next()) {
                Linha = new ArrayList<String>();
                Linha.add(rs.getString("ID_DESPESA"));
                Linha.add(rs.getString("RAZAO"));
                Linha.add(rs.getString("VALOR"));
                Linha.add(rs.getString("DATA_HORA"));
                Linha.add(rs.getString("ID_GRUPO"));
                Linha.add(rs.getString("ID_USUARIO"));
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
        
        try {
            
            auten = "SELECT id_grupo FROM USUARIO_GRUPO WHERE id_usuario = '" + usuarioID + "'";
                        
            stmt = connection.createStatement();
            rs = stmt.executeQuery(auten);
            
            while (rs.next()) {
                List.add(rs.getString("id_grupo"));
            }                        
        } catch (SQLException ex) {
            System.out.println("Erro na consulta");
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
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
