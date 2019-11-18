
package com.suicidaesquadrao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VendaDAO {
    
    public String GerarNumVenda(){
        
        String numVenda="";
        String sql = "SELECT MAX(NUMVENDA) FROM VENDAS";
        try {
            Connection conexao = ConexaoBD.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                numVenda = rs.getString(1);
            }                   
        } catch (Exception e) {
        }
        return numVenda;
    }
    
}
