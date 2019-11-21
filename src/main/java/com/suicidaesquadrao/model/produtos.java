
package com.suicidaesquadrao.model;

import util.validacaoException;



public class produtos {
    
    private int id;
    private String nome;
    private int quantidade;
    private double preco;
    private int filial;
    

    public produtos(int id, String nome, int quantidade, double preco, int filial) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.filial = filial;
        
    }

    public produtos(){
        
    }
    
    public void valida () throws validacaoException{
        if(nome==null||nome.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    
    
    
}
