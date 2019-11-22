<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
     <script type="text/javascript">
            function Voltar(){
                location.href = 'main.jsp';
            }
            
            function Alerta(){
                alert("Salvo com sucesso!");
            }

            </script>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Produtos</h1>
        <hr>
        <form action="produtoControle" method="POST">
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preco</th>
            <th>Filial</th>
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
        <a href=produtoControle?acao=salvar><input type="button" value="Cadastrar"></a>        
        <input type="button" value="Sair" onClick="Voltar()"> 
    </body>
</html>
