
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.produtoDAO;
import com.suicidaesquadrao.model.produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;

/**
 *
 * @author Deise
 */
public class produtoControle extends HttpServlet {

    private produtoDAO ProdutoDAO = new produtoDAO();
    
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
            Integer idProduto = Integer.parseInt(id);
            ProdutoDAO.excluir(idProduto);
            request.setAttribute("mensagem", "Produto excluído!");
            }else if(acao!=null && acao.equals("editar")){
            Integer idProduto = Integer.parseInt(id);
            produtos produto = ProdutoDAO.getProdutoId(idProduto);
            request.setAttribute("produto", produto);
            }    
        request.setAttribute("produtos", ProdutoDAO.getProduto());
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
        dispatcher.forward(request, response);
        
        
        
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome= request.getParameter("nome");
        float quantidade=Float.parseFloat(request.getParameter("quantidade"));
        double preco=Double.parseDouble(request.getParameter("preco"));
        int filial=Integer.parseInt(request.getParameter("filial"));
        String id = request.getParameter("id");
        
        produtos produto = new produtos(0,nome,quantidade,preco,filial);
        if (id!=null && !id.equals("")){
            produto.setId(Integer.parseInt(id));
        }
        try{
            
         produto.valida();
         if(produto.getId()!=0){
             ProdutoDAO.atualizar(produto);
             request.setAttribute("mensagem", "Produto atualizado"); 
             
         }else{
             ProdutoDAO.salvar(produto);
             request.setAttribute("mensagem", "Produto Salvo");
         }
           
          
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Validacao dos Campos: "+ ex.getMessage());
           request.setAttribute("produtos", produto);
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("produtos", produto);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("produtos", produto);
        }  
        try{
            request.setAttribute("produtos", ProdutoDAO.getProduto());
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("produtos", produto);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("produtos", produto);
        }  

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
        dispatcher.forward(request, response);
        
    }

    
    

}
