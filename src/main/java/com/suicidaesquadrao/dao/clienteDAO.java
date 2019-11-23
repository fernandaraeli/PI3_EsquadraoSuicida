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
    
    
    
    
    
    //Método para buscar clientes no Banco    
    public clientes buscar(String cnpj){
        clientes c = new clientes();
        String sql = "SELECT * FROM cliente WHERE cnpj=" + cnpj;
        try{
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            c.setId(rs.getInt(1));
            c.setRazao(rs.getString(2));
            c.setCnpj(rs.getString(3));
            c.setTelefone(rs.getString(4));
            c.setEmail(rs.getString(5));
            c.setEndereco(rs.getString(6));
            c.setComplemento(rs.getString(7));
            c.setNumero(rs.getString(8));
            c.setCep(rs.getString(9));
            c.setBairro(rs.getString(10));
            c.setCidade(rs.getString(11));
            }
        }catch(Exception e){    
        }
        return c;
    }
    
    
    
    //Metodo inserir cadastro de cliente
    public void salvar (clientes cliente)throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO cliente (razao,cnpj,telefone,email,endereco,complemento,numero,cep,bairro,cidade) VALUES(?,?,?,?,?,?,?,?,?,?)");
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
    

    //Metodo excluir cadastro de cliente
    public void excluir(Integer idCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("delete from cliente where id=?");
        ps.setInt(1, idCliente);
             
        ps.execute();
    }
    
    
    //Metodo Atualizar cadastro de cliente
    public void atualizar(clientes cliente)throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE cliente SET razao=?,cnpj=?,telefone=?,email=?,endereco=?,complemento=?,numero=?,cep=?,bairro=?,cidade=? WHERE id=?");
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
    
    
    //Metodo listar todos os clientes
    public List<clientes> listarCliente() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id,razao,cnpj,telefone,email,endereco,complemento,numero,cep,bairro,cidade FROM cliente");
        ResultSet rs = ps.executeQuery();
        List<clientes> cli = new ArrayList();
        while(rs.next()){
            cli.add(new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
       
        }
    return cli;   
    }
    
    

    public clientes getClienteID(Integer idCliente) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id,razao,cnpj,telefone,email,endereco,complemento,numero,cep,bairro,cidade FROM cliente WHERE id=?");
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)); 
        }
        throw new validacaoException("Não achou cliente com código" +idCliente);
    }
    
    
    public List<clientes> getCliente() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT id,razao,cnpj,telefone,email,endereco,complemento,numero,cep,bairro,cidade FROM cliente");
        ResultSet rs = ps.executeQuery();
        List<clientes> cli = new ArrayList();
        while(rs.next()){
            cli.add(new clientes(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
       
        }
    return cli;   
    }
    

}
