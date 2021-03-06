
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Cadastro Filiais</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav> 
           <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02"><a href="filialControle?acao=salvar" class="btn btn-success">Cadastrar</a> </div>
        </nav>     
        
        <form method="POST" action="filialControle">    
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>CNPJ</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Ação</th>
            <th>Ação</th>
           </tr>
           
            <c:forEach var="c" items="${filiais}">
                <tr>
                    <td>${c.id_filial}</td>
                    <td>${c.cnpj_filial}</td>
                    <td>${c.nome_filial}</td>
                    <td>${c.desc_filial}</td>
                    <td>${c.cidade_filial}</td>
                    <td>${c.estado_filial}</td>
                    
                    <td><a href=filialControle?acao=editar&id=${c.id_filial}>Editar</a></td>
                    <td><a href=filialControle?acao=excluir&id=${c.id_filial}>Excluir</a></td>
                </tr>
              
            </c:forEach>
        </table>         
        </form>
      </body>
</html>
