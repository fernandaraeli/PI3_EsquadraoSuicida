<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faturamento por Periodo</title>
    </head>
    <body>
        <h1>Faturamento por Período</h1>
        
        <form action="ControladorPrincipal?menu=Relatorios&acao=FaturamentoPeriodo">
        <input type="text" name="cnpj" value="${cliente.getCnpj()}" class="form-control" placeholder="CNPJ" required>                                
        <input type="submit" name="acao" value="BuscarCliente" class="btn btn-outline-info">  
        </form>
     
        
    </body>
</html>
