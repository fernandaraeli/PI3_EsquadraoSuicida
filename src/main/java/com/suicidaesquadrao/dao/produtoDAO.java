package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;


public class produtoDAO {
    
    int retorno;
    
    
    //Metodo para buscar um produto pelo ID.
    public produtos buscarProduto(int idProduto){
        produtos prod = new produtos();
        try {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produto WHERE id_produto=" + idProduto);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            prod.setId(rs.getInt(1));
            prod.setNome(rs.getString(2));
            prod.setQuantidade(rs.getInt(3));
            prod.setPreco(rs.getDouble(4));
            prod.setFilial(rs.getInt(5));
        }
        } catch (Exception e) {
        }return prod;
    }
    
    
    
    //Metodo para atualizar a quantidade no estoque
    public int atualizarEstoque(int idProduto, int qtd){
        try {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE produto SET quantidade_produto=? WHERE id_produto=?");
        ps.setInt(1, qtd);
        ps.setInt(2, idProduto);
        ps.executeUpdate();
        } catch (Exception e) {
        }return retorno;
    }
    
    
    //Exclui Produtos
    public void excluir(Integer idProduto) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM produto WHERE id_produto=?");
        ps.setInt(1, idProduto);
             
        ps.execute();
    }
    //Seleciona produto para alterar
    public produtos getProdutoId(Integer idProduto) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id_produto,nome_produto,quantidade_produto,preco_produto,id_filial FROM produto WHERE id_produto=?");
        ps.setInt(1, idProduto);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new produtos(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
       
        }
        throw new validacaoException("Não achou produto com código"+idProduto);
    }
    
    // Listar produtos na tela
    public List<produtos> getProduto() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id_produto,nome_produto,quantidade_produto,preco_produto,id_filial FROM produto");
        ResultSet rs = ps.executeQuery();
        List<produtos> prod = new ArrayList();
        while(rs.next()){
            prod.add(new produtos(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
       
        }
    return prod;   
    }
    // Salvar Produto
    public void salvar (produtos produto)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO produto (nome_produto,quantidade_produto,preco_produto,id_filial) VALUES(?,?,?,?)");
        ps.setString(1, produto.getNome());
        ps.setInt(2, produto.getQuantidade());
        ps.setDouble(3, produto.getPreco());
        ps.setInt(4, produto.getFilial());
        
        
        ps.execute();
    }
    //atualiza produto
    public void atualizar(produtos produto)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE produto SET nome_produto=?, quantidade_produto=?, preco_produto=?, id_filial=?  WHERE id_produto=?");
        ps.setString(1, produto.getNome());
        ps.setInt(2, produto.getQuantidade());
        ps.setDouble(3, produto.getPreco());
        ps.setInt(4, produto.getFilial());
        ps.setInt(5, produto.getId());
        ps.execute(); 
    }
    
}
