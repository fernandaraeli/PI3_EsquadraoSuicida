package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;


public class clienteDAO {

    public void excluir(Integer idCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID=?");
        ps.setInt(1, idCliente);
             
        ps.execute();
    }

    public clientes getClienteID(Integer idCliente) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,RAZAO,CNPJ,TELEFONE,EMAIL,ENDERECO,COMPLEMENTO,NUMERO,CEP,BAIRRO,CIDADE FROM CLIENTE WHERE ID=?");
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)); 
        }
        throw new validacaoException("Não achou cliente com código" +idCliente);
    }
    
    
    public List<clientes> getCliente() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,RAZAO,CNPJ,TELEFONE,EMAIL,ENDERECO,COMPLEMENTO,NUMERO,CEP,BAIRRO,CIDADE FROM CLIENTE");
        ResultSet rs = ps.executeQuery();
        List<clientes> cli = new ArrayList();
        while(rs.next()){
            cli.add(new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
       
        }
    return cli;   
    }
    
    public void salvar (clientes cliente)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO CLIENTE (RAZAO,CNPJ,TELEFONE,EMAIL,ENDERECO,COMPLEMENTO,NUMERO,CEP,BAIRRO,CIDADE) VALUES(?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, cliente.getRazao());
        ps.setString(2, cliente.getCnpj());
        ps.setString(3, cliente.getTelefone());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getEndereco());
        ps.setString(6, cliente.getComplemento());
        ps.setString(7, cliente.getNumero());
        ps.setString(8, cliente.getCep());
        ps.setString(9, cliente.getBairro());
        ps.setString(10, cliente.getCidade());
        
        
        ps.execute();
    }

    public void atualizar(clientes cliente)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE CLIENTE SET RAZAO=?,CNPJ=?,TELEFONE=?,EMAIL=?,ENDERECO=?,COMPLEMENTO=?,NUMERO=?,CEP=?,BAIRRO=?,CIDADE=? WHERE ID=?");
        ps.setString(1, cliente.getRazao());
        ps.setString(2, cliente.getCnpj());
        ps.setString(3, cliente.getTelefone());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getEndereco());
        ps.setString(6, cliente.getComplemento());
        ps.setString(7, cliente.getNumero());
        ps.setString(8, cliente.getCep());
        ps.setString(9, cliente.getBairro());
        ps.setString(10, cliente.getCidade());
        ps.setInt(11, cliente.getId());
        ps.execute(); 
    } 
    
    
        public List<clientes> listarCliente() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,RAZAO,CNPJ,TELEFONE,EMAIL,ENDERECO,COMPLEMENTO,NUMERO,CEP,BAIRRO,CIDADE FROM CLIENTE");
        ResultSet rs = ps.executeQuery();
        List<clientes> cli = new ArrayList();
        while(rs.next()){
            cli.add(new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
       
        }
    return cli;   
    }
}
