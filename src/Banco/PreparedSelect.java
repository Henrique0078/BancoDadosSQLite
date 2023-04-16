/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Conexoes.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class PreparedSelect {
    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        
        conexaoSQLite.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        
        String sql = "SELECT * FROM tabela_pessoa"
                + "WHERE id = ?;";
        
        
        
        try{
            int idPessoa = 1;
            
            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, idPessoa);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                System.out.println("Dados da Pessoa!!!");
                System.out.println("Codigo: " + resultSet.getInt("cd_pessoa"));
                System.out.println("Nome: " + resultSet.getString("nm_nome"));
                System.out.println("Email: " + resultSet.getString("ds_email"));
                System.out.println("Salario: R$" + resultSet.getDouble("vl_salario"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException ex){
                System.out.println("Erro no fechamento!!");
            }
        }
        
    }
}
