<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Clientes TESTE</title>
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
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">  <a href="clienteControle?acao=salvar" class="btn bg-light">Cadastrar</a></div>
        </nav>
        
       
        
   
        <form action="clienteControle" method="POST">
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>Razão Social</th>
            <th>CNPJ</th>
            <th>Telefone</th>
            <th>E-mail</th>
            <th>Endereço</th>
            <th>Complemento</th>
            <th>Número</th>
            <th>CEP</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Ação</th>
            <th>Ação</th>
            
            </tr>
            <c:forEach var="c" items="${clientes}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.razao}</td>
                    <td>${c.cnpj}</td>
                    <td>${c.telefone}</td>
                    <td>${c.email}</td>
                    <td>${c.endereco}</td>
                    <td>${c.complemento}</td>
                    <td>${c.numero}</td>
                    <td>${c.cep}</td>
                    <td>${c.bairro}</td>
                    <td>${c.cidade}</td>
                    <td><a href=clienteControle?acao=editar&id=${c.id}>Editar</a>
                    <td><a href=clienteControle?acao=excluir&id=${c.id}>Excluir</a>
                </tr>
            </c:forEach>
        </table>
        </form>
   
                
       
    </body>
</html>
