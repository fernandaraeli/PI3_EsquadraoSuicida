<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Produtos</title>
    </head>
     <script type="text/javascript">
            function Alerta(){
                alert("Salvo com sucesso!");
            }

            </script>
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
                <a class="nav-link" href="ControladorPrincipal?menu=FaturamentoDiario&acao=default">Relatórios</a>
           </strong>
        </li>
    </ul>
      
      
      
 
  </div>
</nav>
   <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav>  
        
           <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">   <a href="produtoControle?acao=salvar" class=" btn bg-light">Cadastrar</a> </div>
        </nav>   
        
        <form action="produtoControle" method="POST">
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preco</th>
            <th>Filial</th>
                 <th>Ação</th>
            <th>Ação</th>
            </tr>
            <c:forEach var="p" items="${produtos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nome}</td>
                    <td>${p.quantidade}</td>
                    <td>${p.preco}</td>
                    <td>${p.filial}</td>
                    <td><a href=produtoControle?acao=editar&id=${p.id}>Editar</a>
                    <td><a href=produtoControle?acao=excluir&id=${p.id}>Excluir</a>
                </tr>
            </c:forEach> 
        </table>     
        </form>
        <!--
        <a href="produtoControle?acao=salvar" class="btn btn-success">Cadastrar</a>        
        <a href="main.jsp" class="btn btn-danger">Sair</a> 
        
        -->
    </body>
</html>
