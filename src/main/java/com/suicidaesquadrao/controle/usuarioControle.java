/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.usuarioDao;
import com.suicidaesquadrao.model.usuarios;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;

/**
 *
 * @author Flavio
 */
public class usuarioControle extends HttpServlet {

         
     private usuarioDao UsuarioDAO = new usuarioDao();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String acao=request.getParameter("acao");
       String id=request.getParameter("id");
        
       try{
           
           if(acao!=null && acao.equals("excluir")){
               Integer idUsuario = Integer.parseInt(id);
               UsuarioDAO.excluir(idUsuario);
               request.setAttribute("mensagem", "Usuários Exluido com Sucesso");               
           }
           
           else if((acao!=null) && acao.equals("Editar")){
            
           Integer idUsuario = Integer.parseInt(id);
           usuarios usuario = UsuarioDAO.getUsuariosID(idUsuario);
           request.setAttribute("usuario", usuario);          
           }
           
           request.setAttribute("usuario",UsuarioDAO.getUsuarios());
       }  catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        } 
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario.jsp");
       dispatcher.forward(request, response); 
       
       }
   
       
      
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String id = request.getParameter("id_filial");
        String nome =request.getParameter("nome_usuario");
        String usuario = request.getParameter("user");
        String senha = request.getParameter("senha");
        
    
        // tem uma mudança aqui
        
        usuarios usuarios2 = new usuarios(0, nome, usuario, senha, 0, 0);
        if (id!= null && !id.equals("")) {
            
            usuarios2.setId(Integer.parseInt(id));      
        } 
            
        
           try{
            
         
         usuarios2.valida();
         if(usuarios2.getId() !=0){
             
            UsuarioDAO.atualizar(usuarios2);
            request.setAttribute("mensagem", "Usuário Atualizado");          
         } else {
             UsuarioDAO.salvar(usuarios2);
             request.setAttribute("mensagem", "Usuário Atualizado");
         } 
             
             
            
          
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Validacao dos Campos: "+ ex.getMessage());
           request.setAttribute("Usuários ", usuario);
           
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("Usuários ", usuario);
           
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("Usuários ", usuario);
        }  
        try{
            request.setAttribute("usuarios", UsuarioDAO.getUsuarios());
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
            request.setAttribute("Usuários ", usuario);
           
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("Usuários ", usuario);
        }  

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario.jsp");
        dispatcher.forward(request, response);
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
