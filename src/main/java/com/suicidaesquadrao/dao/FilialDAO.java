/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.dao.ConexaoBD;
import com.suicidaesquadrao.dao.ConexaoBD;
import com.suicidaesquadrao.model.Filial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;

/**
 *
 * @author Deise
 */
public class FilialDAO {

    public List<Filial> getFiliais() throws SQLException, ClassNotFoundException{
        Connection conex = ConexaoBD.getConnection();
        PreparedStatement ps = conex.prepareStatement("SELECT id_filial, cnpj_filial, nome_filial, desc_filial, "
                + "cidade_filial, estado_filial FROM filial ");
        ResultSet rs = ps.executeQuery();
        List<Filial> filiais = new ArrayList<>();
        while(rs.next()){
            filiais.add(new Filial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6)));
        }
        return filiais;
    }
    
    public void salvar(Filial filial) throws ClassNotFoundException, SQLException {
        Connection conex = ConexaoBD.getConnection();
        PreparedStatement statement = conex.prepareStatement("INSERT INTO filial(id_filial, cnpj_filial, nome_filial,"
                + " desc_filial,cidade_filial, estado_filial) VALUES (?,?,?,?,?,?)");
        statement.setInt(1, filial.getId_filial());
        statement.setString(2, filial.getCnpj_filial());
        statement.setString(3, filial.getNome_filial());
        statement.setString(4, filial.getDesc_filial());
        statement.setString(5, filial.getCidade_filial());
        statement.setString(6, filial.getEstado_filial());
        
        statement.execute();
    }
    
    
    public void excluir(int id_filial) throws SQLException, ClassNotFoundException {
        Connection conex = ConexaoBD.getConnection();
        PreparedStatement statement = conex.prepareStatement("DELETE FROM filial WHERE id_filial = ?");
        
        statement.setInt(1, id_filial);
        statement.execute();
    }
    
    public static Filial getId_filial(Integer id_filial) throws validacaoException, SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id_filial, cnpj_filial, nome_filial ,desc_filial,"
                + "cidade_filial, estado_filial FROM filial WHERE id_filial = ?");
        ps.setInt(1, id_filial);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new Filial(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
       
        }
        throw new validacaoException("Não achou produto com código"+id_filial);
    }
    
    public void atualizar(Filial filial)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE filial SET cnpj_filial=?, nome_filial=?, desc_filial=?,"
                + "cidade_filial =?, estado_filial=? WHERE id_filial=?");
        
        ps.setString(1, filial.getCnpj_filial());
        ps.setString(2, filial.getNome_filial());
        ps.setString(3, filial.getDesc_filial());
        ps.setString(4, filial.getCidade_filial());
        ps.setString(5, filial.getEstado_filial());
        ps.setInt(6, filial.getId_filial());
        ps.execute(); 
    }
}
