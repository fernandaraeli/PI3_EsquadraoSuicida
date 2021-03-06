package com.suicidaesquadrao.dao;

import static com.suicidaesquadrao.dao.ConexaoBD.getConnection;
import com.suicidaesquadrao.model.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;


public class usuarioDao {

    public void excluir(int idUsuario) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");
        ps.setInt(1, idUsuario);
             
        ps.execute();
    }

    public usuarios getUsuarioID(Integer idUsuario) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id_usuario,nome_usuario,user,senha,id_filial,id_perfil FROM usuario WHERE id_usuario=?");
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new usuarios(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)); 
        }
        throw new validacaoException("Não achou usuário com código" +idUsuario);
    }
    
    
    public List<usuarios> getUsuario() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id_usuario,nome_usuario,user,senha,id_filial,id_perfil FROM usuario");
        ResultSet rs = ps.executeQuery();
        List<usuarios> usr = new ArrayList();
        while(rs.next()){
            usr.add(new usuarios(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
       
        }
    return usr;   
    }
    
    public void salvar (usuarios usuario)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO usuario (nome_usuario,user,senha,id_filial,id_perfil) VALUES(?,?,?,?,?)");
        ps.setString(1, usuario.getNome_usuario());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getId_filial());
        ps.setInt(5, usuario.getId_perfil());

        ps.execute();
    }

    public void atualizar(usuarios usuario)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE usuario SET nome_usuario=?,user=?,senha=?,id_filial=?,id_perfil=? WHERE id_usuario=?");
        ps.setString(1, usuario.getNome_usuario());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getId_filial());
        ps.setInt(5, usuario.getId_perfil());
        ps.setInt(6, usuario.getId_usuario());
        ps.execute(); 
    }  
     
    public boolean autenticacao( String usuario, String senha) throws ClassNotFoundException, SQLException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            
            String consulta= "select * from usuario where user=? and senha=?";
            pst = conexao.prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();
           
            if(rs.absolute(1)){
                System.out.println("Acessou");
                return true;
            } 
           
        } catch (Exception e)  {            
            System.err.println("ERRO JAVA " + e);
            
        } 
                
        finally {
            
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close(); 
            } catch (Exception e ){
                  System.err.println("Error 2 " + e);
            }
         
        }
        
       return false;
    }
}
