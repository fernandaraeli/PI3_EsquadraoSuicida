<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
       
        <h1>Cadastro de Usuários</h1>
        <hr>
        <script type="text/javascript">
            
            function Alerta(){
                alert("Cadastro Atualizado!");
            }
            </script>
            
        <form method="POST" action="usuarioControle">
                    
                     <input type="hidden" name="id_usuario" value="${user.id_usuario}"/>
                     <label>ID:</label><input type="text" disabled name="id_usuario" value="${user.id_usuario}"/><br/>
                     <label>Nome:</label><input type="text" name="nome_usuario" value="${user.nome_usuario}"/><br/>
                     <label>Login:</label><input type="text" name="user" value="${user.user}"/><br/>
                     <label>Senha:</label><input type="password" name="senha"value="${user.senha}"/><br/>
                     <label>Filial:</label><input type="text" name="id_filial" value="${user.id_filial}"/><br/>
                     <label>Perfil:</label><input type="text" name="id_perfil" value="${user.id_perfil}"/><br/>
                     

                     
                     <input type="submit" value="Salvar" onclick="Alerta()">
                     <input type="reset" value="Limpar">
                     <a href=usuarioControle?&acao=Voltar><input type="button" value="Voltar"></a> 
        </form> 
    </body>
</html>
