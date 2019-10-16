<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes TESTE</title>
    </head>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Clientes</h1>
        <hr>
        <form method="POST" action="clienteControle">
        <table border="1">
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
        <br>
        
    </body>
</html>
