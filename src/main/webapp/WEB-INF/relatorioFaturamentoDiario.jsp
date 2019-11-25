<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Faturamento Diario</title>
    </head>
     <script type="text/javascript">
            function Alerta(){
                alert("");
            }

    </script>
    <body>
        <h1>Faturamento Diario</h1>
        <hr>
        <form action="ControlePrincipal?menu=FaturamentoDiario" method="POST">
        <table class="table table-hover">
            <tr>
            <th>IdVenda</th>
            <th>IdCliente</th>
            <th>IdUsuario</th>
            <th>NumVenda</th>
            <th>DataVenda</th>
            <th>TotalPagar</th>
            <th>Status</th>
            </tr>
            <c:forEach var="v" items="${lista}}">
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
        </table>
        </form>
        <a href="ControlePrincipal?menu=FaturamentoDiario&acao=Pesquisar" class="btn btn-success">Pesquisar</a>
        <a href="main.jsp" class="btn btn-danger">Sair</a>
        <br>
        
    </body>
</html>

