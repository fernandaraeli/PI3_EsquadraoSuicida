<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Venda</title>
                </head>
                    <body>  
                        <div class="d-flex">
                        <div class="col-sm-4">
                        <div class="card">
                        <form action="ControladorPrincipal?menu=NovaVenda" method="POST">
                        <div class="card-body">  
  
                       
                        <!--DADOS DO CLIENTE-->                            
                        <div class="form-group"><label>Dados Cliente</label></div>                       
                        <div class="form-group d-flex">     
                        <div class="col-sm-6 d-flex">
                            <input type="text" name="cnpj" value="${cliente.getCnpj()}" class="form-control" placeholder="CNPJ">                                
                            <input type="submit" name="acao" value="BuscarCliente" class="btn btn-outline-info">  
                        </div>
                        <div class="col-sm-6">
                             <input type="text" name="razao" value="${cliente.getRazao()}" placeholder="Cliente" class="form-control"> 
                        </div>
                        </div>  
                        
                        

                        <!--DADOS DO PRODUTO-->    
                        <div class="form-group"><label>Dados Produto</label></div>
                        <div class="form-group d-flex">
                        <div class="col-sm-6 d-flex">
                            <input type="text" name="idproduto" value="${produto.getId()}" class="form-control" placeholder="Codigo">
                            <button type="submit" name="acao" value="BuscarProduto" class="btn btn-outline-info">BuscarProduto</button>                           
                        </div>
                        <div class="col-sm-6"><input type="text" name="nomeproduto" value="${produto.getNome()}" placeholder="Produto" class="form-control"></div>
                        </div>
                        <div class="form-group d-flex">
                        <div class="col-sm-6"><input type="text" name="preco" value="${produto.getPreco()}" placeholder="R$0,00" class="form-control"></div>
                        <div class="col-sm-3"><input type="number" value="1" name="quantidade" placeholder="" class="form-control"></div>
                        <div class="col-sm-3"><input type="text" name="estoque" value="${produto.getQuantidade()}" placeholder="Estoque" class="form-control"></div>
                        </div>
                        
                        
                        
                        
                        <!--BOTÃO PARA INSERIR O ITEM NA VENDA-->   
                        <div class="form-group">
                        <div class="col-sm-3"><button type="submit" name="acao" value="InserirProduto" class="btn btn-outline-info">Inserir</button></div>
                        </div>      
                        </div>
                        </form>  
                        </div>
                        </div>
                        <div class="col-sm-7">
                        <div class="card">                    
                        <div class="card-body">

                            
                            
                            
                        <!--ITENS DA VENDA--> 
                          
                        <div class="form-group d-flex">
                        <div class="col-sm-5"><label>Cliente:</label><input type="text" name="razao" value="${cliente.getRazao()}" placeholder="Cliente" class="form-control"></div>   
                        </div>
                       
                        <div class="d-flex col-sm-5 ml-auto"><label>Nº Venda:</label><input type="text" name="NroVenda" value="${numVenda}" class="form-control"></div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Numero</th>
                                    <th>Código</th>
                                    <th>Descrição</th>
                                    <th>Preço</th>
                                    <th>Quantidade</th>
                                    <th>Subtotal</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="v" items="${lista}">
                                <tr>
                                    <td>${v.getNumItem()}</td>
                                    <td>${v.getIdProduto()}</td>
                                    <td>${v.getNomeProduto()}</td>
                                    <td>${v.getPreco()}</td>
                                    <td>${v.getQuantidade()}</td>
                                    <td>${v.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px;">Remover</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        <div class="card-footer d-flex">
                        <div class="col-sm-6">
                        <a href="ControladorPrincipal?menu=NovaVenda&acao=Finalizar" class="btn btn-success">Finalizar</a>    
                        <a href="ControladorPrincipal?menu=NovaVenda&acao=Cancelar" class="btn btn-danger">Cancelar</a> 
                        </div>
                        </div>
                        <div class="col-sm-4 ml-auto"><input type="text" value="R$ ${totalPagar}"name="total" class="form-control"></div>       
                        </div>
                        </div>           
                        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
</html>
