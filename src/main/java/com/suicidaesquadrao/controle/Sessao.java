/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.usuarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Sessao extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
   
   
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String usu = request.getParameter("txtuser");
        String sen = request.getParameter("txtsenha");
        
              
        usuarioDao co = new  usuarioDao();  

                     
        try {
            if(co.autenticacao(usu, sen)){         
         
                HttpSession objsesion = request.getSession(false);
                objsesion.setAttribute("usuario", usu);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
                dispatcher.forward(request, response);
                
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
