
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.clienteDAO;
import com.suicidaesquadrao.model.clientes;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


public class clienteControle extends HttpServlet {

    private clienteDAO ClienteDAO = new clienteDAO();    
    
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
            Integer idCliente = Integer.parseInt(id);
            ClienteDAO.excluir(idCliente);
            request.setAttribute("mensagem", "Cliente Excluído!");
            
            }
            
            else if(acao!=null && acao.equals("editar")){
            Integer idCliente = Integer.parseInt(id);
            clientes cliente = ClienteDAO.getClienteID(idCliente);
            request.setAttribute("cliente", cliente);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clientes.jsp");
            dispatcher.forward(request, response);
            }
            
            else if(acao!=null && acao.equals("salvar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clientes.jsp");
            dispatcher.forward(request, response);
            
            }
            
            else if(acao!=null && acao.equals("voltar")){
            request.setAttribute("clientes", ClienteDAO.getCliente());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarClientes.jsp");
            dispatcher.forward(request, response);
            }
        
            request.setAttribute("clientes", ClienteDAO.getCliente());
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        
        request.getRequestDispatcher("/WEB-INF/listarClientes.jsp").forward(request, response);
 
    }
    
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String razao= request.getParameter("razao");
        String cnpj=request.getParameter("cnpj");
        String telefone= request.getParameter("telefone");
        String email= request.getParameter("email");
        String endereco= request.getParameter("endereco");
        String complemento= request.getParameter("complemento");
        String numero= request.getParameter("numero");
        String cep= request.getParameter("cep");
        String bairro= request.getParameter("bairro");
        String cidade= request.getParameter("cidade");    
        String id = request.getParameter("id");
        
        clientes cliente = new clientes(0, razao, cnpj, telefone, email, endereco, complemento, numero, cep, bairro, cidade);
        if (id!=null && !id.equals("")){
            cliente.setId(Integer.parseInt(id));
        }
        
        try{
            
         cliente.valida();
         if(cliente.getId()!=0){
             ClienteDAO.atualizar(cliente);
             request.setAttribute("mensagem", "Cliente Atualizado");
             request.setAttribute("clientes", ClienteDAO.getCliente());
             
         }else{
             ClienteDAO.salvar(cliente);
             request.setAttribute("mensagem", "Cliente Salvo");
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clientes.jsp");
             dispatcher.forward(request, response);
         }
           
          
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Validacao dos Campos: "+ ex.getMessage());
           request.setAttribute("Clientes", cliente);
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("clientes", cliente);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("clientes", cliente);
        }  
        try{
            request.setAttribute("clientes", ClienteDAO.getCliente());
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("clientes", cliente);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("clientes", cliente);
        }  
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/clientes.jsp");
        dispatcher.forward(request, response);
        
    }

    
    

}
