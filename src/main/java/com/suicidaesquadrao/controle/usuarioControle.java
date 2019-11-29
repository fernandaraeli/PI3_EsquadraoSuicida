
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

    private usuarioDao udao = new usuarioDao();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
                
        String acao=request.getParameter("acao");
        String id=request.getParameter("id_usuario");
        
        try{
            if(acao!=null && acao.equals("excluir")){
            Integer id_usuario = Integer.parseInt(id);
            udao.excluir(id_usuario);
            request.setAttribute("mensagem", "Usuario Excluído!");
            request.setAttribute("usuarios", udao.getUsuario());
            }
            
            else if(acao!=null && acao.equals("editar")){
            Integer id_usuario = Integer.parseInt(id);
            usuarios usuario = udao.getUsuarioID(id_usuario);
            request.setAttribute("usuarios", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
            dispatcher.forward(request, response);
            }
            
            else if(acao!=null && acao.equals("salvar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
            dispatcher.forward(request, response);
            }
            
            else if(acao!=null && acao.equals("voltar")){
            request.setAttribute("usuarios", udao.getUsuario());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarUsuarios.jsp");
            dispatcher.forward(request, response);
            }
        
            request.setAttribute("usuarios", udao.getUsuario());
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        
        request.getRequestDispatcher("/WEB-INF/listarUsuarios.jsp").forward(request, response);
 
    }
    
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id_usuario");
        String nome= request.getParameter("nome");
        String user=request.getParameter("user");
        String senha= request.getParameter("senha");
        Integer id_filial= Integer.parseInt(request.getParameter("id_filial"));   
        Integer id_perfil= Integer.parseInt(request.getParameter("id_perfil"));  
        
        
        usuarios usuario = new usuarios(0, nome, user, senha, id_filial, id_perfil);
        if (id!=null && !id.equals("")){
            usuario.setId_usuario(Integer.parseInt(id));
        }
        
        try{
            
         usuario.valida();
         if(usuario.getId_usuario()!=0){
             udao.atualizar(usuario);
             request.setAttribute("mensagem", "Usuario Atualizado");
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
             dispatcher.forward(request, response);

             
         }else{
             udao.salvar(usuario);
             request.setAttribute("mensagem", "Usuario Salvo");
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
             dispatcher.forward(request, response);
         }
           
        
         request.setAttribute("usuarios", udao.getUsuario());  
         
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
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarUsuarios.jsp");
        dispatcher.forward(request, response);
        
    }

    
    

}
