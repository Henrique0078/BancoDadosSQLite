/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Conexoes.ConexaoSQLite;
import Conexoes.CriarBancoSQLite;
import Conexoes.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class BancoDados {
    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);
        
        criarBancoSQLite.criarTabela();
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setCd_pessoa(2);
        pessoa1.setNm_nome("Thayna");
        pessoa1.setDs_email("nordilicht@gmail.com");
        pessoa1.setVl_salario(900);
        
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
