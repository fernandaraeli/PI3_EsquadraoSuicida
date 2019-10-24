

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="Sessao" method="post">
           
            <label><strong>Usuário:</strong> </label>
            <input type="text" name="txtuser" placeholder="Insira o login" size="30"><br><br>
            <label><strong>Senha:</strong>   &nbsp;&nbsp;</label>
            <input type="password" name="txtsenha" placeholder="Insira a senha" size="30"><br><br>
            <input type="submit" name="acao"  value="Acessar">
            
        </form>
    
        
        
    </body>
</html>
