<!DOCTYPE html>
<html>
    <head>
        <title>Cadastros</title>
            <script type="text/javascript">
            function Voltar(){
                location.href = 'login.jsp';
            }
            </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h1>Menu</h1>
        <form>
            <a href="clienteControle">Clientes</a>
            <a href="produtoControle">Produtos</a>
            <a href="usuarioControle">Usuários</a>
            <a href="Servlet">Filial</a>
            
            <input type="button" value="Sair" onClick="Voltar()"> 
        </form>
    </body>
</html>