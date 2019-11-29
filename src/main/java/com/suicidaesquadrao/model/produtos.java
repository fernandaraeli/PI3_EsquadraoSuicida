
package com.suicidaesquadrao.model;

import util.validacaoException;



public class produtos {
    
    private int id_produto;
    private String nome_produto;
    private int quantidade_produto;
    private double preco_produto;
    private int id_filial;
    

    public produtos(int id, String nome, int quantidade, double preco, int filial) {
        this.id_produto = id;
        this.nome_produto = nome;
        this.quantidade_produto = quantidade;
        this.preco_produto = preco;
        this.id_filial = filial;
        
    }

    public produtos(){
        
    }
    
    public void valida () throws validacaoException{
        if(nome_produto==null||nome_produto.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    

}
