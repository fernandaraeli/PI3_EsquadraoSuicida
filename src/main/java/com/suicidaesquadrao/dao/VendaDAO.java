
package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VendaDAO {
    
        Connection con;
        ConexaoBD cbd = new ConexaoBD();
        PreparedStatement ps;
        ResultSet rs;
        int retorno; 
        String resultado;
        
        
    public java.sql.Date getCurrentDatetime() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

        
    //Busca o ultimo numero de venda registrado no banco
    public String buscaUltNumVenda(){
 
        String numVenda="";
        String sql = "select max(numvenda) from venda";
        try {
            con=cbd.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();        
            while(rs.next()){
                numVenda = rs.getString(1);
            }                   
        } catch (Exception e) {
        }
        return numVenda;
    }
    
    
    //Insere a venda no banco
    public int gravarVenda (Venda venda){
        
        
        String sql = "INSERT INTO venda (idcliente, idusuario, numvenda, datavenda, totalpagar, status) VALUES(?,?,?,?,?,?)";
        try {
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdCliente());
            ps.setInt(2, venda.getIdUsuario());
            ps.setString(3, venda.getNumVenda());
            java.sql.Date date = getCurrentDatetime();
            ps.setDate(4, date);
            ps.setDouble(5, venda.getTotalPagar());
            ps.setString(6, venda.getStatusVenda());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return retorno;  
    }
    
    
    //Insere Item detalhado da venda
    public int gravarItemVenda (Venda venda){
        String sql = "INSERT INTO item_venda(idvenda, idproduto, quantidade, precovenda) VALUES(?,?,?,?)";
        try {
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdVenda());
            ps.setInt(2, venda.getIdProduto());
            ps.setInt(3, venda.getQuantidade());
            ps.setDouble(4, venda.getPreco());
            ps.executeUpdate();
        } catch (Exception e) {
        }   
        return retorno;
    }
    
    
    //Listar todas as vendas
    public List listarVenda(){
        List<Venda>lista = new ArrayList<>();
        String sql = "select * from venda";
        try {
            con=cbd.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();        
            while(rs.next()){
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("idvenda"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setNumVenda(rs.getString("numvenda"));
                v.setDataVenda(rs.getDate("datavenda"));
                v.setTotalPagar(rs.getDouble("totalpagar"));
                v.setStatusVenda(rs.getString("status"));
                lista.add(v);
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    //Listar venda pelo número da venda
    public List buscarNumeroVenda(String numvenda){
        List<Venda>lista = new ArrayList<>();
        String sql = "select * from venda where numvenda=" +numvenda;
        try {
            con=cbd.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();        
            while(rs.next()){
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("idvenda"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setNumVenda(rs.getString("numvenda"));
                v.setDataVenda(rs.getDate("datavenda"));
                v.setTotalPagar(rs.getDouble("totalpagar"));
                v.setStatusVenda(rs.getString("status"));
                lista.add(v);
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
        //Listar venda pela Data da Venda
    public List buscarVendaData(String dtvenda){
        List<Venda>lista = new ArrayList<>();
        String sql = "select * from venda where datavenda=" +dtvenda;
        try {
            con=cbd.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();        
            while(rs.next()){
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("idvenda"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setNumVenda(rs.getString("numvenda"));
                v.setData(rs.getDate("datavenda"));
                v.setTotalPagar(rs.getDouble("totalpagar"));
                v.setStatusVenda(rs.getString("status"));
                lista.add(v);
            }
            ps.close();
            con.close();
        } catch (Exception e){ 
            e.printStackTrace();
        }
        return lista;
    }
}
