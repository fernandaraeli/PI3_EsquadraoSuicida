<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Produtos</h1>
        <hr>
        <form method="POST" action="produtoControle">
                     <input type="hidden" name="id" value="${produto.id}"/>
                     <label>ID:</label><input type="text" disabled name="id" value="${produto.id}"/><br/>
                     <label>Nome:</label><input type="text" name="nome" value="${produto.nome}"/><br/>
                     <label>Quantidade:</label><input type="text" name="quantidade"value="${produto.quantidade}"/><br/>
                     <label>Preço:</label><input type="text" name="preco" value="${produto.preco}"/><br/>
                     <label>Filial:</label><input type="text" name="filial" value="${produto.filial}"/><br/>
                     
                     <input type="submit" value="Salvar" onclick="alert('${mensagem}')">
                     <input type="button" value="Sair"><a href="index.html"></a>       
        </form>
        <br>
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
        <br>
        
    </body>
</html>
