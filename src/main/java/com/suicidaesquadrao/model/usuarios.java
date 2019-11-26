/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.model;

import util.validacaoException;

/**
 *
 * @author deise.mfarias
 */
public class usuarios {
    
    private int id_usuario;
    private String nome;
    private String user;
    private String senha;
    private int id_filial;
    private int id_perfil;
    
    public void valida() throws validacaoException {
        if(user==null || senha.equals("")){
            throw new validacaoException ("O campo é Obrigatório");
        }
    }

    public usuarios() {
    }
    
    

    public usuarios(int id_usuario, String nome, String user, String senha, int id_filial, int id_perfil) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.id_filial = id_filial;
        this.id_perfil = id_perfil;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuarios) {
        this.id_usuario = id_usuarios;
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
