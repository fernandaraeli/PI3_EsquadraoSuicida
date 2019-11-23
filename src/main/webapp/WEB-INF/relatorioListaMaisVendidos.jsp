<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio</title>
    </head>
    <body>
        <h1>Lista dos 10 Produtos mais Vendidos</h1>
        
        <form action="ControladorPrincipal?menu=Relatorios&acao=ListaMaisVendidos">
        <input type="text" name="cnpj" value="${cliente.getCnpj()}" class="form-control" placeholder="CNPJ" required>                                
        <input type="submit" name="acao" value="BuscarCliente" class="btn btn-outline-info">  
        </form>
     
        
    </body>
</html>
