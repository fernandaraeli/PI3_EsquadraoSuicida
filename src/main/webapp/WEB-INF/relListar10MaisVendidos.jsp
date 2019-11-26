<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Listar 10 Mais Vendidos</title>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light ">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        
        
      <!--MENUS-->  
      <li class="nav-item">
         <strong> 
             <a class="nav-link" href="main.jsp">
                 <img src="imagem/logoHome.jpg" alt="70" height="22"/></a>
         </strong>
      </li>

      <li class="nav-item">
         <strong> 
             <a class="nav-link" href="clienteControle">Clientes</a>
         </strong>
      </li>
      
       <li class="nav-item">
         <strong> 
        <a class="nav-link" href="filialControle">Filial</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="produtoControle">Produtos</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="usuarioControle">Usuários</a>
           </strong>
      </li>
      
        <li class="nav-item">
           <strong>
               <a class="nav-link" href="ControladorPrincipal?menu=NovaVenda&acao=default">Nova Venda</a>
        </strong>
      </li>
      
        <li class="nav-item">
           <strong>
                <a class="nav-link" href="ControladorPrincipal?menu=Relatorios&acao=default&selecao=default">Relatórios</a>
           </strong>
        </li>
    </ul>
      
      
      
 
  </div>
</nav>
        
<nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav>        
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>IDVENDA</th>
                        <th>IDCLIENTE</th>
                        <th>IDUSUARIO</th>
                        <th>NUMVENDA</th>
                        <th>DATAVENDA</th>
                        <th>TOTALPAGAR</th>
                        <th>STATUS</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="v" items="${vendas}">
                    <tr>
                        <td>${v.getIdVenda()}</td>
                        <td>${v.getIdCliente()}</td>
                        <td>${v.getIdUsuario()}</td>
                        <td>${v.getNumVenda()}</td>
                        <td><fmt:formatDate value="${v.getData()}" type=“date” />${v.getData()}</td>
                        <td>${v.getTotalPagar()}</td>
                        <td>${v.getStatusVenda()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <form action="ControladorPrincipal?menu=Relatorios&acao=Listar10MaisVendidos">
            
            
            
        
        </form>
     
        
    </body>
</html>
