package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.FilialDAO;
import com.suicidaesquadrao.model.Filial;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;




public class filialControle extends HttpServlet {

    private FilialDAO filialDAO = new FilialDAO();
    
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
                Integer id_filial = Integer.parseInt(id);
                filialDAO.excluir(id_filial);
                request.setAttribute("mensagem", "forncedor excluido com sucesso ");
                
                
            }else if(acao!=null && acao.equals("editar")){
                Integer id_filial = Integer.parseInt(id);
                Filial filial = FilialDAO.getId_filial(id_filial);
                request.setAttribute("filial", filial);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filiais.jsp");
                dispatcher.forward(request, response);
            }    
            
            
            else if(acao!=null && acao.equals("salvar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filiais.jsp");
            dispatcher.forward(request, response);
            request.setAttribute("filiais", filialDAO.getFiliais());
            }
            
            else if(acao!=null && acao.equals("voltar")){
            request.setAttribute("filiais", filialDAO.getFiliais());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarFiliais.jsp");
            dispatcher.forward(request, response);
            }
            
            
        request.setAttribute("filiais", filialDAO.getFiliais());
        
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        }        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarFiliais.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id_filial");
        String cnpj = request.getParameter("cnpj_filial");
        String nome = request.getParameter("nome_filial");
        String desc = request.getParameter("desc_filial");
        String cidade = request.getParameter("cidade_filial");
        String estado = request.getParameter("estado_filial");
        
        
        Filial filial = new Filial(0, cnpj, nome, desc, cidade, estado);
        if (id!=null && !id.equals("")){
            filial.setId_filial(Integer.parseInt(id));
        }
        try{
            filial.valida();
            if(filial.getId_filial()!=0){
                filialDAO.atualizar(filial);
                request.setAttribute("mensagem", "Filial atualizada"); 
            }else{
                filialDAO.salvar(filial);
                request.setAttribute("mensagem", "filial salva com sucesso");
            }
        }catch (validacaoException ex){
           request.setAttribute("mensagem", "Erro de Validacao dos Campos: "+ ex.getMessage());
           request.setAttribute("filial", filial);
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("filial", filial);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("filial", filial);
        }  
        try{
            request.setAttribute("filiais", filialDAO.getFiliais());
        }catch (SQLException ex){
           request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
           request.setAttribute("filial", filial);
        }catch (ClassNotFoundException ex){
            request.setAttribute("mensagem", "Erro de Driver: "+ ex.getMessage());
            request.setAttribute("filial", filial);
        }  

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/filiais.jsp");
        dispatcher.forward(request, response);
    }
}
