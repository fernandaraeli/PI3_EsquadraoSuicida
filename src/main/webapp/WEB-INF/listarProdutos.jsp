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
       <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav>  
        
           <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">   <a href="produtoControle?acao=salvar" class=" btn btn-success">Cadastrar</a> </div>
        </nav>   
        
        <form method="POST" action="produtoControle" >
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
                    <td>${p.id_produto}</td>
                    <td>${p.nome_produto}</td>
                    <td>${p.quantidade_produto}</td>
                    <td>${p.preco_produto}</td>
                    <td>${p.id_filial}</td>
                    <td><a href=produtoControle?acao=editar&id=${p.id_produto}>Editar</a>
                    <td><a href=produtoControle?acao=excluir&id=${p.id_produto}>Excluir</a>
                </tr>
            </c:forEach> 
        </table>     
        </form>
    </body>
</html>
