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
            
       
            <label>Nome: </label><input type="text" name="nome" value="${usuario.nome}"/><br>
            <label>Senha:</label> <input type="text" name="senha" value=""/><br>                
            <input type="submit" value="Salvar" onclick="alert('${mensagem}')">
            <input type="reset" value="Limpar">
            <input type="button" value="Sair" onclick="Voltar()">
                     
                 
        </form>       
    </body>
</html>
