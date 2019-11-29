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
        PreparedStatement ps = conexao.prepareStatement("SELECT * FROM PRODUTO WHERE ID_PRODUTO=" + idProduto);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            prod.setId_produto(rs.getInt(1));
            prod.setNome_produto(rs.getString(2));
            prod.setQuantidade_produto(rs.getInt(3));
            prod.setPreco_produto(rs.getDouble(4));
            prod.setId_filial(rs.getInt(5));
        }
        } catch (Exception e) {
        }return prod;
    }
    
    
    
    //Metodo para atualizar a quantidade no estoque
    public int atualizarEstoque(int idProduto, int qtd){
        try {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE PRODUTO SET QUANTIDADE_PRODUTO=? WHERE ID_PRODUTO=?");
        ps.setInt(1, qtd);
        ps.setInt(2, idProduto);
        ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }return retorno;
    }
    
    
    //Exclui Produtos
    public void excluir(Integer idProduto) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID_PRODUTO=?");
        ps.setInt(1, idProduto);
             
        ps.execute();
    }
    //Seleciona produto para alterar
    public produtos getProdutoId(Integer idProduto) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID_PRODUTO, NOME_PRODUTO, QUANTIDADE_PRODUTO, PRECO_PRODUTO, ID_FILIAL FROM PRODUTO WHERE ID_PRODUTO=?");
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
        PreparedStatement ps = conexao.prepareStatement("SELECT ID_PRODUTO, NOME_PRODUTO, QUANTIDADE_PRODUTO, PRECO_PRODUTO, ID_FILIAL FROM PRODUTO");
        ResultSet rs = ps.executeQuery();
        List<produtos> prod = new ArrayList();
        while(rs.next()){
            prod.add(new produtos(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
       
        }
    return prod;   
    }
    // Salvar Produto
    public void salvar (produtos produtos)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO PRODUTO (NOME_PRODUTO, QUANTIDADE_PRODUTO, PRECO_PRODUTO, ID_FILIAL) VALUES(?,?,?,?)");
        ps.setString(1, produtos.getNome_produto());
        ps.setInt(2, produtos.getQuantidade_produto());
        ps.setDouble(3, produtos.getPreco_produto());
        ps.setInt(4, produtos.getId_filial());
        
        ps.execute();
    }
    //atualiza produto
    public void atualizar(produtos produtos)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE PRODUTO SET NOME_PRODUTO=?, QUANTIDADE_PRODUTO=?, PRECO_PRODUTO=?, ID_FILIAL=?  WHERE ID_PRODUTO=?");
        ps.setString(1, produtos.getNome_produto());
        ps.setInt(2, produtos.getQuantidade_produto());
        ps.setDouble(3, produtos.getPreco_produto());
        ps.setInt(4, produtos.getId_filial());
        ps.setInt(5, produtos.getId_produto());
        
        ps.execute(); 
    }
    
}
