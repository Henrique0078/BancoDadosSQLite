/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Henrique
 */
public class ConexaoSQLite {
    
    private Connection conexao;
    
    
    //conecta a um banco de dados (E Cria o banco se nao existir :D)
    public boolean conectar(){
        try{
                String url = "jdbc:sqlite:Banco/bancosqlite.db";
                
                this.conexao = DriverManager.getConnection(url);
        }
        catch(SQLException e){
        System.err.println(e.getMessage());
        return false;
        }
        
        System.out.println("Conectou!!!");    
        return true;
    }
    
    public boolean desconectar(){
        try{
            if (this.conexao.isClosed() == false){
                this.conexao.close();
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
            
        }
        System.out.println("Desconectou!!!");
        return true;
    }
    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
            
        }catch(SQLException e){
            return null;
        }
    }
    public PreparedStatement criarPreparedStatement(String sql){
        try{
            return this.conexao.prepareStatement(sql);
            
        }catch(SQLException e){
            return null;
            
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
}
