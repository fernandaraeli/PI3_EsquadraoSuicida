
package com.suicidaesquadrao.model;

import util.validacaoException;


public class clientes {
    
    private int id;
    private String razao;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private String complemento;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;

    
    public clientes(int id, String razao, String cnpj, String telefone, String email, String endereco, String complemento, String numero, String cep, String bairro, String cidade) {
        this.id = id;
        this.razao = razao;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }
        

    public clientes(){
        
    }
    
    public void valida () throws validacaoException{
        if(razao==null||razao.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }if(cnpj==null){
           throw new validacaoException("O campo é obrigatório");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
