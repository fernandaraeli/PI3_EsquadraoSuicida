<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuario</title>
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
        <h1>Usuarios</h1>
        <hr>
        <form action="usuarioControle" method="POST">
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Login</th>
            <th>Senha</th>
            <th>Filial</th>
            <th>Perfil</th>
            </tr>
            <c:forEach var="u" items="${usuarios}">
                <tr>
                    <td>${u.id_usuario}</td>
                    <td>${u.nome_usuario}</td>
                    <td>${u.user}</td>
                    <td>${u.senha}</td>
                    <td>${u.id_filial}</td>
                    <td>${u.id_perfil}</td>
                    <td><a href=usuarioControle?acao=editar&id=${u.id_usuario}>Editar</a>
                    <td><a href=usuarioControle?acao=excluir&id=${u.id_usuario}>Excluir</a>
                </tr>
            </c:forEach>
        </table>
        </form>
        <a href="usuarioControle?acao=salvar"><input type="button" value="Cadastrar"></a>         
        <input type="button" value="Sair" onClick="Voltar()"> 
        <br>
        
    </body>
</html>
