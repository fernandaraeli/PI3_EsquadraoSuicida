package com.suicidaesquadrao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
    
    public static Connection getConnection ()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/tads?useTimezone=true&serverTimezone=UTC","root","root");
    }
    
}    