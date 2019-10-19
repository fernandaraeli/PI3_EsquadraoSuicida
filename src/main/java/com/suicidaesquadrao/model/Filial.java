/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.model;

import util.validacaoException;

public class Filial {
    private int id_filial;
    private String cnpj_filial;
    private String nome_filial;
    private String desc_filial;
    private String cidade_filial;
    private String estado_filial;
    
    public Filial() {
    }
    
    public void valida () throws validacaoException{
        if(nome_filial==null||nome_filial.equals("")){
            throw new validacaoException("O campo Nome é obrigatório");
        }
    }
    
    public Filial(int id_filial, String cnpj_filial, String nome_filial, String desc_filial, String cidade_filial, String estado_filial) {
        this.id_filial = id_filial;
        this.cnpj_filial = cnpj_filial;
        this.nome_filial = nome_filial;
        this.desc_filial = desc_filial;
        this.cidade_filial = cidade_filial;
        this.estado_filial = estado_filial;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    public String getCnpj_filial() {
        return cnpj_filial;
    }

    public void setCnpj_filial(String cnpj_filial) {
        this.cnpj_filial = cnpj_filial;
    }

    public String getNome_filial() {
        return nome_filial;
    }

    public void setNome_filial(String nome_filial) {
        this.nome_filial = nome_filial;
    }

    public String getDesc_filial() {
        return desc_filial;
    }

    public void setDesc_filial(String desc_filial) {
        this.desc_filial = desc_filial;
    }

    public String getCidade_filial() {
        return cidade_filial;
    }

    public void setCidade_filial(String cidade_filial) {
        this.cidade_filial = cidade_filial;
    }

    public String getEstado_filial() {
        return estado_filial;
    }

    public void setEstado_filial(String estado_filial) {
        this.estado_filial = estado_filial;
    }
}
