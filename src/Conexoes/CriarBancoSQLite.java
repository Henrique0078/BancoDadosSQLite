/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexoes;

import Conexoes.ConexaoSQLite;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Henrique
 */
public class CriarBancoSQLite {
    
    private final ConexaoSQLite conexaoSQLite;
    
    public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite){
        this.conexaoSQLite = pConexaoSQLite;
    }
    public void criarTabela(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tabela_pessoa("
                + "cd_pessoa integer primary key,"
                + "nm_nome text,"
                + "ds_email text,"
                + "vl_salario real"
                + ");";
        
        //executando sql de criar tabela
        
        boolean conectou = false;
        
        try{
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela Pessoa CRIADA!!!");
            
        }catch(SQLException e){
            //mensagem de erro na criacao da tabela
        }
        finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
}
