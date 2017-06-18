/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repsplitacc;

import java.util.ArrayList;

/**
 *
 * @author bmr
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexaoBanco aux = new ConexaoBanco();
        boolean verifica;
        ArrayList<ArrayList<String>> Despesas;
        ArrayList<String> Linha;
        ArrayList<String> Relacao;
        
        verifica = aux.conectar();
        if(verifica == false)
        {
            System.out.println("Erro");
        }
        verifica = aux.AutenticaUsuario("raull", "123456789");
        System.out.println(verifica);
        Despesas = aux.DespesasDoGrupo("100");
        
        
        for(int i = 0; i < Despesas.size(); i++){
            Linha = Despesas.get(i);
            for(int j = 0; j < Linha.size(); j++){
                System.out.println(Linha.get(j));
            }
            Linha.clear();
        }
        
        Despesas.clear();
        
       Relacao = aux.GruposUsuario("1");
       
       System.out.println("Relacao");
       
       for(int i = 0; i < Relacao.size(); i++){
           System.out.println(Relacao.get(i));
       }
       
       Relacao.clear();
        
        aux.FechaBD();
    }
    
}
