<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Venda Efetuada</title>
    </head>
    <body>
        
        
        <h1>Venda Efetuada</h1>
        
        
        <form action="ControladorPrincipal?menu=NovaVenda" method="POST">
              <label>Cliente:</label><input type="text" name="razao" value="${cliente.getRazao()}" class="form-control">
              <label>Nº Venda:</label><input type="text" name="NroVenda" value="${numVenda}" class="form-control">
              <label>Nº Venda:</label><input type="text" name="Total a Pagar" value=" ${totalPagar}" class="form-control">
        </form>
              <a href="ControladorPrincipal?menu=NovaVenda&acao=default" class="btn btn-success">OK</a>
    </body>
</html>
