/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Conexoes.ConexaoSQLite;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Henrique
 */
public class Select {
    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        
        ResultSet resultSet = null;
        Statement statement = null;
        conexaoSQLite.conectar();
        
        String query = "SELECT * FROM tabela_pessoa;";
        
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                System.out.println("--------------------------------------");
                System.out.println("Dados das Pessoas!!");
                System.out.println("Codigo: " + resultSet.getInt("cd_pessoa"));
                System.out.println("Nome: " + resultSet.getString("nm_nome"));
                System.out.println("Email: " + resultSet.getString("ds_email"));
                System.out.println("Salario: R$" + resultSet.getDouble("vl_salario"));
                
            }
        }catch(SQLException e){
            System.out.println("Erro!!");
        }finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException e){
                System.out.println("Erro Misterioso de fechamento");
            }
        }
    }
}
