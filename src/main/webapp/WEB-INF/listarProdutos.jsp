<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
     <script type="text/javascript">
            function Voltar(){
                location.href = 'main.jsp';
            }
            
            function Alerta(){
                alert("Salvo com sucesso!");
            }

            </script>
    </head>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Produtos</h1>
        <hr>
        <form method="POST" action="produtoControle">
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preco</th>
            <th>Filial</th>
           
            </tr>
            <c:forEach var="c" items="${produtos}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.quantidade}</td>
                    <td>${c.preco}</td>
                    <td>${c.filial}</td>
                    <td><a href=produtoControle?acao=editar&id=${c.id}>Editar</a>
                    <td><a href=produtoControle?acao=excluir&id=${c.id}>Excluir</a>
                </tr>
            </c:forEach>
                
        </table>     
        </form>
        <a href=produtoControle?acao=salvar><input type="button" value="Cadastrar"></a>        
        <input type="button" value="Sair" onClick="Voltar()"> 
    </body>
</html>
