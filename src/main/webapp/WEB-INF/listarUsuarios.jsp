<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Lista Usuario</title>
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
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02"> <a href="usuarioControle?acao=salvar" class="btn btn-success">Cadastrar</a></div>
        </nav>
        
        
        <form action="usuarioControle" method="POST">
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Login</th>
            <th>Senha</th>
            <th>Filial</th>
            <th>Perfil</th>
            <th>Ação</th>
            <th>Ação</th>
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
        <!--
        <a href="usuarioControle?acao=salvar" class="btn btn-success">Cadastrar</a>    
        <a href="main.jsp" class="btn btn-danger">Sair</a> 
        <br>
        -->
        
    </body>
</html>
