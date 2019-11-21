
package com.suicidaesquadrao.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    Connection con;
   
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        try {
              System.out.println("Conectando ao banco...");
              Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tads?useTimezone=true&serverTimezone=UTC","root","root");
              
        }catch (Exception e){
            System.out.println("ERRO DE BANCO:"+ e);
        }
        
        return con;
    }
    
}
