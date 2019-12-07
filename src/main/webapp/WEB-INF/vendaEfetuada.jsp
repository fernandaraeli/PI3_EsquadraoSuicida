<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Venda Efetuada</title>
    </head>
    <body>
    <center>
        <br>
        <br>
    
        <h1>Venda Efetuada</h1>
        <br>
        <div>
            <img src="imagem/Check-icon.png"  alt="100" height="80"/>
        </div>
        <br>
        <br>
        
        <div>
            <form action="ControladorPrincipal?menu=NovaVenda" method="POST">
                <div>
                   <b>Número da Venda:</b> ${ultVenda}<br>
                </div>
                <br>
                <div>
                    <b>Cliente:</b> ${cliente.getRazao()}<br>
                </div>
                <br>
                <div>
                    <b>Total da Venda:</b> R$ ${totalPagar}<br>
                </div>
            </form>
                <br>
            <a href="ControladorPrincipal?menu=NovaVenda&acao=default" class="btn btn-success">OK</a>
        </div> 
    </center>
    </body>
</html>
