/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.model;

import util.validacaoException;

/**
 *
 * @author Flavio
 */
public class usuarios {
    
    private int id;
    private String nome;
    private String user;
    private String senha;
    private int id_filial;
    private int id_perfil;


      public void valida () throws validacaoException{
        if(user==null||senha.equals("")){
            throw new validacaoException("O campo é obrigatório");
        //}if(quantidade==0){
          //  throw new validacaoException("O campo é obrigatório");
        //}if(preco==0){
            //throw new validacaoException("O campo é obrigatório");
        //}if(filial==0){
          //  throw new validacaoException("O campo é obrigatório");
        }
    }

    public usuarios(int id, String nome, String usuario, String senha, int id_filial, int id_perfil) {
        this.id = id;
        this.nome = nome;
        this.user = usuario;
        this.senha = senha;
        this.id_filial = id_filial;
        this.id_perfil = id_perfil;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
      
    

    
    
}
