<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Listar 10 Mais Vendidos</title>
    </head>
    <body>
       <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav> 
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>IDVENDA</th>
                        <th>IDCLIENTE</th>
                        <th>IDUSUARIO</th>
                        <th>NUMVENDA</th>
                        <th>DATAVENDA</th>
                        <th>TOTALPAGAR</th>
                        <th>STATUS</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="v" items="${vendas}">
                    <tr>
                        <td>${v.getIdVenda()}</td>
                        <td>${v.getIdCliente()}</td>
                        <td>${v.getIdUsuario()}</td>
                        <td>${v.getNumVenda()}</td>
                        <td><fmt:formatDate value="${v.getData()}" type=“date” />${v.getData()}</td>
                        <td>${v.getTotalPagar()}</td>
                        <td>${v.getStatusVenda()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <form action="ControladorPrincipal?menu=Relatorios&acao=Listar10MaisVendidos">
            
            
            
        
        </form>
     
        
    </body>
</html>
