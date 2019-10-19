<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Usuários</h1>
        <hr>
        <script type="text/javascript">
            function Voltar(){
                location.href = 'index.html';
            }
            </script>
        
    <form method="POST" action="usuarioControle">
            <input type="hidden" name="id_usuario" value="${usuario.id_usuario}"/>
            <label>ID:</label><input type="text" disabled name="id" value="${usuario.id_usuario}"/><br>
            <label>Nome: </label><input type="text" name="nome" value="${usuario.nome_usuario}"/><br>
            <label>Usuário: </label><input type="text" name="user" value="${usuario.user}"/><br>
            <label>Senha:</label> <input type="text" name="senha" value="${usuario.senha}"/><br> 
            <label>Filial:</label> <input type="text" name="senha" value="${usuario.id_filial}"/><br>  
            <label>Perfil:</label> <input type="text" name="senha" value="${usuario.id_perfil}"/><br>  
            <input type="submit" value="Salvar" onclick="alert('${mensagem}')">
            <input type="reset" value="Limpar">
            <input type="button" value="Sair" onclick="Voltar()">         
        </form>  
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Usuário</th>
            <th>Senha</th>
            <th>Filial</th>
            <th>Perfil</th>
          
           
            </tr>
            <c:forEach var="u" items="${usuarios}">
                <tr>
                    <td>${u.id_usuario}</td>
                    <td>${u.nome_usuario}</td>
                    <td>${u.user}</td>
                    <td>${c.senha}</td>
                    <td>${c.id_filial}</td>
                    <td>${c.id_perfil}</td>
                    <td><a href=usuarioControle?acao=editar&id=${c.id}>Editar</a>
                    <td><a href=usuarioControle?acao=excluir&id=${c.id}>Excluir</a>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
