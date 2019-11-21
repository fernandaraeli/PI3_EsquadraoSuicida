
package com.suicidaesquadrao.dao;

import com.suicidaesquadrao.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;


public class VendaDAO {
    
        Connection con;
        ConexaoBD cbd = new ConexaoBD();
        PreparedStatement ps;
        ResultSet rs;
        int retorno;    
    
    
    //Busca o ultimo numero de venda registrado no banco
    public String buscaUltNumVenda(){
        
         
        String numVenda="";
        String sql = "SELECT MAX(NUMVENDA) FROM VENDA";
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
        String sql = "INSERT INTO VENDA (IDCLIENTE, IDUSUARIO, NUMVENDA, DATAVENDA, TOTALPAGAR, STATUS) VALUES(?,?,?,?,?,?)";
        try {
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, venda.getIdCliente());
            ps.setInt(2, venda.getIdUsuario());
            ps.setString(3, venda.getNumVenda());
            ps.setString(4, venda.getDataVenda());
            ps.setDouble(5, venda.getTotalPagar());
            ps.setString(6, venda.getStatusVenda());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return retorno;  
    }
    
    
    //Insere Item detalhado da venda
    public int gravarItemVenda (Venda venda){
        String sql = "INSERT INTO ITEM_VENDA(IDVENDA, IDPRODUTO, QUANTIDADE, PRECOVENDA) VALUES(?,?,?,?)";
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
    
    
    
}
