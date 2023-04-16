/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Conexoes.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class Insert {
    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);
        
        criarBancoSQLite.criarTabela();
        int cdpessoa = 11;
        String nome = "Atal";
        String email = "OLA";
        double salario = 1500;
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setCd_pessoa(cdpessoa);
        pessoa1.setNm_nome(nome);
        pessoa1.setDs_email(email);
        pessoa1.setVl_salario(salario);
        
        conexaoSQLite.conectar();
        
        String sqlInsert = " INSERT INTO tabela_pessoa ("
                + "cd_pessoa,"
                + "nm_nome,"
                + "ds_email,"
                + "vl_salario"
                + ")VALUES(?,?,?,?)"
                + ";";
        
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        
        try{
            
            preparedStatement.setInt(1, pessoa1.getCd_pessoa());
            preparedStatement.setString(2, pessoa1.getNm_nome());
            preparedStatement.setString(3, pessoa1.getDs_email());
            preparedStatement.setDouble(4, pessoa1.getVl_salario());
            
            int resultado = preparedStatement.executeUpdate();
            
            if (resultado == 1){
                System.out.println("Pessoa Inserida!!");
            }
            else{
                System.out.println("Pessoa nao inserida");
            }
        }catch(SQLException e){
            System.out.println("Pessoa nao inserida");
        }finally{
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        conexaoSQLite.desconectar();
    }
}
