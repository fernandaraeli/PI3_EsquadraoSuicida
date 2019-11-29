
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.produtoDAO;
import com.suicidaesquadrao.model.produtos;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


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
            //para excluir produto
            if(acao!=null && acao.equals("excluir")){
            Integer idProduto = Integer.parseInt(id);
            ProdutoDAO.excluir(idProduto);
            request.setAttribute("mensagem", "Produto excluído!");
            request.setAttribute("produtos", ProdutoDAO.getProduto());
            
            //Editar
            }else if(acao!=null && acao.equals("editar")){
            Integer idProduto = Integer.parseInt(id);
            produtos produto = ProdutoDAO.getProdutoId(idProduto);
            request.setAttribute("produtos", produto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
            dispatcher.forward(request, response);
            }  
            
            else if(acao!=null && acao.equals("salvar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
            dispatcher.forward(request, response);
            }
            
            else if(acao!=null && acao.equals("voltar")){
            request.setAttribute("produtos", ProdutoDAO.getProduto());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarProdutos.jsp");
            dispatcher.forward(request, response);
            
            }
                 
        //atualiza lista    
        request.setAttribute("produtos", ProdutoDAO.getProduto());
        
        //Trativa de erros
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarProdutos.jsp");
        dispatcher.forward(request, response); 
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //preencher campos
        String id = request.getParameter("id");
        String nome= request.getParameter("nome");
        int quantidade=Integer.parseInt(request.getParameter("quantidade"));
        double preco=Double.parseDouble(request.getParameter("preco"));
        int filial=Integer.parseInt(request.getParameter("filial"));
        
        produtos produto = new produtos(0,nome,quantidade,preco,filial);
        
        if (id!=null && !id.equals("")){
            produto.setId_produto(Integer.parseInt(id));
        }
        try{
         //valida campo e atualiza   
         produto.valida();
         if(produto.getId_produto()!=0){
             ProdutoDAO.atualizar(produto);
             request.setAttribute("mensagem", "Produto atualizado");
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
             dispatcher.forward(request, response);
                          
         }else{
             ProdutoDAO.salvar(produto);
             request.setAttribute("mensagem", "Produto Salvo");
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
             dispatcher.forward(request, response);
         }
         request.setAttribute("produtos", ProdutoDAO.getProduto());
           
         //Tratativas de Erro 
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
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/produtos.jsp");
        dispatcher.forward(request, response);
        
    }
}
