
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
            request.setAttribute("mensagem", "Usuário Excluído!");
            }
            
            else if(acao!=null && acao.equals("editar")){
            Integer idUsuario = Integer.parseInt(id);
            usuarios usuario = UsuarioDAO.getUsuarioID(idUsuario);
            request.setAttribute("usuario", usuario);
            }    
        
            request.setAttribute("usuarios", UsuarioDAO.getUsuario());
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
        dispatcher.forward(request, response);
 
    }
    
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome_usuario= request.getParameter("nome_usuario");
        String user=request.getParameter("user");
        String senha= request.getParameter("senha");
        String id_filial= request.getParameter("id_filial");
        String id_perfil= request.getParameter("id_perfil");    
        String id_usuario = request.getParameter("id_usuario");
        
        usuarios usuario = new usuarios(0, user, user, senha, 0, 0);
        if (id_usuario!=null && !id_usuario.equals("")){
            usuario.setId_usuario(Integer.parseInt(id_usuario));
        }
        
        try{
            
         usuario.valida();
         if(usuario.getId_usuario()!=0){
             UsuarioDAO.atualizar(usuario);
             request.setAttribute("mensagem", "Usuário Atualizado");
            
             
         }else{
             UsuarioDAO.salvar(usuario);
             request.setAttribute("mensagem", "Usuário Salvo");
             
         }
           
          
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Validacao dos Campos: "+ ex.getMessage());
           request.setAttribute("usuarios", usuario);
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("usuarios", usuario);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("usuarios", usuario);
        }  
        try{
            request.setAttribute("usuarios", UsuarioDAO.getUsuario());
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("usuarios", usuario);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("usuarios", usuario);
        }  

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
        dispatcher.forward(request, response);
        
    }

    
    

}
