/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;

/**
 *
 * @author Flavio
 */
public class usuarioDao {
    
    
    public void excluir(Integer idUsuarios) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
       // PreparedStatement ps = conexao.prepareStatement("DELETE FROM usuario WHERE ID=?");
        
       PreparedStatement ps = conexao.prepareStatement("DELETE FROM USUARIO WHERE ID=?");
        ps.setInt(1, idUsuarios);
             
        ps.execute();
    }
    
    
    
    public usuarios getUsuariosID(Integer idUsuarios) throws validacaoException, SQLException, ClassNotFoundException {
        
        Connection conexao = ConexaoBD.getConnection();
       //PreparedStatement ps = conexao.prepareStatement("select id_usuario,nome_usuario,user,senha from usuario where id_usuario=?");
       PreparedStatement ps = conexao.prepareStatement("SELECT ID_USUARIO, NOME_USUARIO,USUARIO, SENHA FROM USUARIO, ID_FILIAL, ID_PERFIL WHERE ID_USUARIO=?");
        
        ps.setInt(1, idUsuarios);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            return new usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6));
        }
        throw new validacaoException("Não achou cliente com código" +idUsuarios);
        
    } 
      
    public List<usuarios> getUsuarios()  throws SQLException, ClassNotFoundException {
        
        Connection conexao = ConexaoBD.getConnection();
        //PreparedStatement ps = conexao.prepareStatement("select id_usuario, nome_filial, user, senha, from usuario");
        PreparedStatement ps = conexao.prepareStatement("SELECT ID_USUARIO, NOME_USUARIO, USUARIO, SENHA, ID_FILIAL, ID_PERFIL FROM USUARIO");
        ResultSet rs = ps.executeQuery();
        List<usuarios> usu = new ArrayList();
        
        while(rs.next()){
            usu.add(new usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));
            
        }
        
        return usu;
        
    }
            
        public void salvar (usuarios usuario) throws SQLException, ClassNotFoundException{
            
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement("insert into usuario (nome_usuario,usuario, senha) values (?,?,?,?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getUser());
            ps.setString(3, usuario.getSenha());
            
            ps.execute();
            
        }

        public void atualizar(usuarios usuario) throws SQLException, ClassNotFoundException {
        
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("update usuario set nome_usuario=?, usuario=?, senha=? where id_usuario=?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        ps.execute();
        
        }
        
        

            

    
}
