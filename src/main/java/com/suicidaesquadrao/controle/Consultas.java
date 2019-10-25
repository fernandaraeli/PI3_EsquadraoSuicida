
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Consultas extends ConexaoBD {
    
    public boolean autenticacao( String usuario, String senha) throws ClassNotFoundException, SQLException{
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            
            String consulta= "select * from usuario where usuario=? and senha=?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();
                     
            
            if(rs.absolute(1)){
                System.out.println("ENTORU NO ABSOLUTE FLAVIÃOOOOOO");
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
    
    
    /*
    public static void main (String[] args ) throws ClassNotFoundException, SQLException{
        Consultas co = new Consultas();
        System.out.println(co.autenticacao("flavio.oliveira","abc123"));        
     
    } 
            
   */
   
    
}
