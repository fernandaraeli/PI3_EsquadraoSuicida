<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Faturamento Diario</title>
    </head>
    <body>
        <div>
            <h1>Faturamento Diário</h1><br/>
        </div>
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
                        <td>${v.getDataVenda()}</td>
                        <td>${v.getTotalPagar()}</td>
                        <td>${v.getStatusVenda()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="ControladorPrincipal?menu=FaturamentoDiario" method="POST">
                <input type="submit" name="acao" value="Pesquisar" class="btn btn-success">
                <input type="submit" name="acao" value="Imprimir" onclick="print()" class="btn btn-info">
                <a href="main.jsp" class="btn btn-danger">Sair</a>
            </form>
        </div>
    
    </body>
</html>
