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
            function Voltar(){
                location.href = 'main.jsp';
            }
            
            function Alerta(){
                alert("Salvo com sucesso!");
            }

            </script>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Clientes</h1>
        <hr>
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
        <a href="clienteControle?acao=salvar"><input type="button" value="Cadastrar"></a>         
        <input type="button" value="Sair" onClick="Voltar()"> 
        <br>
        
    </body>
</html>
