<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produto</h1>
        <hr/>
        <form method="POST" action="produtoControle">
            <label>ID:</label><input type="text" disabled name="id"><br/>
                     <label>Nome:</label><input type="text" name="Nome"><br/>
                     <label>Quantidade:</label><input type="text" name="quantidade"><br/>
                     <label>Preço:</label><input type="text" name="preco"><br/>
                     <label>Filial:</label><input type="text" name="filial"><br/>
                     
                     <input type="submit" value="Salvar" onclick="alert('${mensagem}')"><a href="produto.jsp"></a> 
                     <input type="button" value="Sair"><a href="produto.jsp"></a>       
        </form>
    </body>
</html>
