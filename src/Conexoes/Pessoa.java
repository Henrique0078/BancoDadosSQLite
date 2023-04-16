/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexoes;

/**
 *
 * @author Henrique
 */
public class Pessoa {
    private int cd_pessoa;
    private String nm_nome;
    private String ds_email;
    private double vl_salario;

    public int getCd_pessoa() {
        return cd_pessoa;
    }

    public String getNm_nome() {
        return nm_nome;
    }

    public void setCd_pessoa(int cd_pessoa) {
        this.cd_pessoa = cd_pessoa;
    }

    public void setNm_nome(String nm_nome) {
        this.nm_nome = nm_nome;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public void setVl_salario(double vl_salario) {
        this.vl_salario = vl_salario;
    }

    public String getDs_email() {
        return ds_email;
    }

    public double getVl_salario() {
        return vl_salario;
    }
    
}
