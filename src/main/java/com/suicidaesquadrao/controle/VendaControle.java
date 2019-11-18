
package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.clienteDAO;
import com.suicidaesquadrao.model.clientes;
import com.suicidaesquadrao.dao.produtoDAO;
import com.suicidaesquadrao.model.produtos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suicidaesquadrao.model.Venda;
import java.util.ArrayList;
import java.util.List;


public class VendaControle extends HttpServlet {

    clienteDAO cdao = new clienteDAO();
    clientes cliente = new clientes();
    produtoDAO pdao = new produtoDAO();
    produtos produto = new produtos();
    double total;

    //Instanciar a tabela de venda.
    Venda venda = new Venda();
    List<Venda>lista=new ArrayList<>();
    int item;
    int codigo;
    String descricao;
    double preco;
    int quantidade;
    double subtotal; 
    
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               

        request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp").forward(request, response);
         
    }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao=request.getParameter("acao");
                
        try {
            
            //Buscar cliente no BD através do CNPJ
            if(acao!=null && acao.equals("BuscarCliente")){
            String cnpj = request.getParameter("cnpj");
            cliente.setCnpj(cnpj);
            cliente = cdao.buscar(cnpj);
            request.setAttribute("cliente", cliente);
            }
            
            
            //Buscar produto no BD através do ID
            else if(acao!=null && acao.equals("BuscarProduto")){
            int id = Integer.parseInt(request.getParameter("idproduto"));
            produto = pdao.getProdutoId(id);
            request.setAttribute("cliente", cliente);
            request.setAttribute("produto", produto);
            request.setAttribute("lista", lista);
            request.setAttribute("total", total);
            }
            
            
             //Inserir o item na Venda
            else if(acao!=null && acao.equals("InserirProduto")){
                request.setAttribute("cliente", cliente);
                total = 0.0;
                item = item+1; //contador
                codigo = produto.getId();
                descricao = request.getParameter("nomeproduto");
                preco = Double.parseDouble(request.getParameter("preco"));
                quantidade = Integer.parseInt(request.getParameter("quantidade"));
                subtotal = preco+quantidade;
                
                //SET nos campos da tabela de venda
                venda=new Venda();
                venda.setItem(item);
                venda.setId(codigo);
                venda.setDescricao(descricao);
                venda.setQuantidade(quantidade);
                venda.setSubtotal(subtotal);
                
                lista.add(venda);
                for (int i = 0; i < lista.size(); i++) {
                    total= total + lista.get(i).getSubtotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("lista", lista);
            }
            

        } catch (Exception e) {
            }
           
        request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp").forward(request, response);

    }  

}
