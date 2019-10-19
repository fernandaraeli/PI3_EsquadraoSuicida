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
        <form method="POST" action="usuarioControle">
                     <input type="hidden" name="id" value="${usuario.id}"/>
                     <label>ID:</label><input type="text" disabled name="id" value="${usuario.id}"/><br/>
                     <label>Nome:</label><input type="text" name="nome" value="${usuario.nome}"/><br/>
                     <label>Usuario:</label><input type="text" name="quantidade"value="${usuario.usuario}"/><br/>
                     <label>Senha:</label><input type="text" name="preco" value="${usuario.senha}"/><br/>                  
                     
                     <input type="submit" value="Salvar" onclick="alert('${mensagem}')">
                     <input type="button" value="Sair"><a href="index.html"></a>       
        </form>
        <br>
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Usuário</th>
            <th>Senha</th>
          
           
            </tr>
            <c:forEach var="u" items="${usuarios}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.nome}</td>
                    <td>${u.usuario}</td>
                    <td>${c.senha}</td>
                    <td><a href=usuarioControle?acao=editar&id=${c.id}>Editar</a>
                    <td><a href=usuarioControle?acao=excluir&id=${c.id}>Excluir</a>
                </tr>
            </c:forEach>
                
        </table>
        <br>
        
    </body>
</html>

