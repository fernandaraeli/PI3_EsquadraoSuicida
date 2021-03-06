package com.suicidaesquadrao.controle;

import com.suicidaesquadrao.dao.VendaDAO;
import com.suicidaesquadrao.dao.clienteDAO;
import com.suicidaesquadrao.dao.produtoDAO;
import com.suicidaesquadrao.dao.usuarioDao;
import com.suicidaesquadrao.model.GerarNumVenda;
import com.suicidaesquadrao.model.Venda;
import com.suicidaesquadrao.model.clientes;
import com.suicidaesquadrao.model.produtos;
import com.suicidaesquadrao.model.usuarios;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ControladorPrincipal extends HttpServlet {
    
    clienteDAO cdao = new clienteDAO();
    clientes cliente = new clientes();
    produtoDAO pdao = new produtoDAO();
    produtos produto = new produtos();
    VendaDAO vdao = new VendaDAO();
    Venda venda = new Venda();
  
    //Criar ArrayList para exibição dos itens na tela de venda
    List<Venda>lista=new ArrayList<>();
    int item;
    int codigo;
    String descricao;
    double preco;
    int quantidade;
    double subtotal; 
    double totalPagar;
    Date data;
    String numVenda;
    String ultVenda;
    int idCli;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        
    String menu=request.getParameter("menu");
    String acao=request.getParameter("acao");
    String selecao=request.getParameter("selecao");
   
    if(menu.equals("NovaVenda")){
        venda = new Venda();
        switch (acao){
            case "BuscarCliente":
                //Buscar cliente no BD através do CNPJ
                String cnpj = request.getParameter("cnpj");
                cliente.setCnpj(cnpj);
                cliente = cdao.buscar(cnpj);
                request.setAttribute("cliente", cliente);
                request.setAttribute("numVenda", numVenda);
                request.setAttribute("totalPagar", totalPagar);
                break;
            case "BuscarProduto": 
                //Buscar produto no BD através do ID

                try {
                int idp = Integer.parseInt(request.getParameter("idproduto"));
                produto = pdao.getProdutoId(idp);
                request.setAttribute("produto", produto);
                request.setAttribute("lista", lista);
                request.setAttribute("cliente", cliente);
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("numVenda", numVenda);
                break;   
                } catch (Exception e) {
                }
            case "InserirProduto":
                //Listar os produtos na tela de venda
                request.setAttribute("cliente", cliente);
                totalPagar = 0.0;
                item = item+1; //contador
                codigo = produto.getId_produto();
                descricao = request.getParameter("nomeproduto");
                preco = Double.parseDouble(request.getParameter("preco"));
                quantidade = Integer.parseInt(request.getParameter("quantidade"));
                subtotal = preco*quantidade; 
                
                //SET nos campos da tabela de venda e adiciona do ArrayList
                venda=new Venda();
                venda.setNumItem(item);
                venda.setIdProduto(codigo);
                venda.setNomeProduto(descricao);
                venda.setPreco(preco);
                venda.setQuantidade(quantidade);
                venda.setSubtotal(subtotal);
                lista.add(venda); 
                //Calcula o totalPagar dos itens
                for (int i = 0; i < lista.size(); i++) {
                totalPagar= totalPagar + lista.get(i).getSubtotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("lista", lista);
                request.setAttribute("numVenda", numVenda);
                break;
            case "Finalizar":
                //Atualizar o Estoque
                for (int i = 0; i < lista.size(); i++) {
                produtos produto = new produtos();
                //capturar os valores quantidade e idproduto
                int quantidade = lista.get(i).getQuantidade();
                int idProduto = lista.get(i).getIdProduto();
                produtoDAO proddao = new produtoDAO();
                produto = proddao.buscarProduto(idProduto);
                int estoqueAtual = (produto.getQuantidade_produto()-quantidade);
                proddao.atualizarEstoque(idProduto, estoqueAtual);
                }
                //Armazenar os itens na tabela Venda
                venda.setIdCliente(cliente.getId());
                venda.setIdUsuario(1);
                venda.setNumVenda(numVenda);
                venda.setDataVenda(data);
                venda.setTotalPagar(totalPagar);
                venda.setStatusVenda("1");
                vdao.gravarVenda(venda);  
                
                //Armazenar o item detalhado da venda na tabela item_venda
                int idvenda = Integer.parseInt(vdao.buscaUltNumVenda());
                for (int i = 0; i < lista.size(); i++) {
                venda=new Venda();
                venda.setIdVenda(idvenda);
                venda.setIdProduto(lista.get(i).getIdProduto());
                venda.setQuantidade(lista.get(i).getQuantidade());
                venda.setPreco(lista.get(i).getPreco());
                vdao.gravarItemVenda(venda);
                venda = new Venda();
                //Gerar o numero da Venda
                numVenda = vdao.buscaUltNumVenda();
                ultVenda = numVenda;
                if(numVenda==null){
                numVenda="000000001";
                request.setAttribute("numVenda", numVenda);
                }
                else{
                int incrementar=Integer.parseInt(numVenda);
                GerarNumVenda gerarNum = new GerarNumVenda();
                numVenda = gerarNum.NumeroVenda(incrementar);
                request.setAttribute("numVenda", numVenda); 
                }
                }
                request.setAttribute("ultVenda", ultVenda);
                request.setAttribute("cliente", cliente);
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("/WEB-INF/vendaEfetuada.jsp").forward(request, response);
                lista=new ArrayList<>();
                item = 0;
                totalPagar = 0;
                break;
            case "Cancelar":
                venda = new Venda();
                lista=new ArrayList<>();
                totalPagar = 0;
                request.setAttribute("totalPagar", totalPagar);
                break;
            default:
                //Gerar o numero da Venda
                numVenda = vdao.buscaUltNumVenda();
                if(numVenda==null){
                numVenda="000000001";
                request.setAttribute("numVenda", numVenda);
                }
                else{
                int incrementar=Integer.parseInt(numVenda);
                GerarNumVenda gerarNum = new GerarNumVenda();
                numVenda = gerarNum.NumeroVenda(incrementar);
                request.setAttribute("numVenda", numVenda); 
            }
            request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp").forward(request, response);
        }
    
    //Menu Relatórios
    if(menu.equals("Relatorios")){
        switch (acao){
            case "ListarVendas":
                 switch (selecao){
                    case "Pesquisar":
                        List<Venda>vendas=vdao.listarVenda();
                        request.setAttribute("vendas", vendas);
                        request.getRequestDispatcher("/WEB-INF/relListarVendas.jsp").forward(request, response);
                        break;
                    case "Imprimir":
                        request.getRequestDispatcher("/WEB-INF/relListarVendas.jsp").forward(request, response);
                    case "Exportar":
                        
                        BufferedWriter bf=null;
                        FileWriter fileWriter=null;
                        try {
                            File file = new File("saida.txt");
                            fileWriter = new FileWriter(file);
                            bf= new BufferedWriter(fileWriter);
                            bf.write("Teste");
                            } catch (IOException e) {
                            e.printStackTrace();
                        }finally{
			bf.close();
			fileWriter.close();
                       }
                    default:
                        request.getRequestDispatcher("/WEB-INF/relListarVendas.jsp").forward(request, response);
                 } 
            
            case "FaturamentoDiario":
                switch (selecao){
                    /*case "Pesquisar":
                        //buscar pelo numero da venda
                        numVenda = request.getParameter("numvenda");
                        venda.setNumVenda(numVenda);                        
                        List<Venda>vendas=vdao.buscarNumeroVenda(numVenda);
                        request.setAttribute("vendas", vendas);
                        request.getRequestDispatcher("/WEB-INF/relFaturamentoDiario.jsp").forward(request, response);
                        break;*/
                        
                    case "Pesquisar":
                        //buscar pela data da venda
                        String dtVenda = request.getParameter("datavenda");
                        venda.setDataFormatada(dtVenda);
                        List<Venda>vendas=vdao.buscarVendaData(dtVenda);
                        request.setAttribute("vendas", vendas);
                        request.getRequestDispatcher("/WEB-INF/relFaturamentoDiario.jsp").forward(request, response);
                        break; 
                        
                    case "Imprimir":
                        request.getRequestDispatcher("/WEB-INF/relFaturamentoDiario.jsp").forward(request, response);
                    default:
                        request.getRequestDispatcher("/WEB-INF/relFaturamentoDiario.jsp").forward(request, response);
                }
            
            case "Listar10MaisVendidos":
                switch (selecao){
                    case "Pesquisar":
                        //List<Venda>vendas=vdao.listarVenda();
                        //request.setAttribute("vendas", vendas);
                        request.getRequestDispatcher("/WEB-INF/relListar10MaisVendidos.jsp").forward(request, response);
                        break;
                    case "Imprimir":
                        request.getRequestDispatcher("/WEB-INF/relListar10MaisVendidos.jsp").forward(request, response);
                    default:
                        request.getRequestDispatcher("/WEB-INF/relListar10MaisVendidos.jsp").forward(request, response);
                }
             default:
                    request.getRequestDispatcher("/WEB-INF/relatorios.jsp").forward(request, response);    
    }
    } 
    }  
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
