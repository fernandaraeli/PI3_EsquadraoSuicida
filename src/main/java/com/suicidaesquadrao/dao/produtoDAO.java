package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;


public class produtoDAO {

    public void excluir(Integer idProduto) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID=?");
        ps.setInt(1, idProduto);
             
        ps.execute();
    }

    public produtos getProdutoId(Integer idProduto) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,NOME,QUANTIDADE,PRECO,FILIAL FROM PRODUTO WHERE ID=?");
        ps.setInt(1, idProduto);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new produtos(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDouble(4),rs.getInt(5));
       
        }
        throw new validacaoException("Não achou produto com código"+idProduto);
    }
    
    
    public List<produtos> getProduto() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,NOME,QUANTIDADE,PRECO,FILIAL FROM PRODUTO");
        ResultSet rs = ps.executeQuery();
        List<produtos> prod = new ArrayList();
        while(rs.next()){
            prod.add(new produtos(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDouble(4),rs.getInt(5)));
       
        }
    return prod;   
    }
    
    public void salvar (produtos produto)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO PRODUTO (NOME, QUANTIDADE, PRECO, FILIAL) VALUES(?,?,?,?)");
        ps.setString(1, produto.getNome());
        ps.setFloat(2, produto.getQuantidade());
        ps.setDouble(3, produto.getPreco());
        ps.setInt(4, produto.getFilial());
        
        
        ps.execute();
    }

    public void atualizar(produtos produto)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE PRODUTO SET NOME=?, QUANTIDADE=?, PRECO=?, FILIAL=? WHERE ID=?");
        ps.setString(1, produto.getNome());
        ps.setFloat(2, produto.getQuantidade());
        ps.setDouble(3, produto.getPreco());
        ps.setInt(4, produto.getFilial());
        ps.setInt(5, produto.getId());
        ps.execute(); 
    }
    
}
