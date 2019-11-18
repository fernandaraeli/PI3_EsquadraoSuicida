
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Filiais</title>
    </head>
           <script type="text/javascript">
            function Voltar(){
                location.href = 'main.jsp';
            }
            </script>
    <body>
        
        
        
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Filiais</h1>
        <hr>
        <form method="POST" action="filialControle">    
        <table border="1">
            <tr>
            <th>Id</th>
            <th>CNPJ</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Cidade</th>
            <th>Estado</th>
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
                <a href=filialControle?acao=salvar><input type="button" value="Cadastrar"></a>        
                <input type="button" value="Sair" onClick="Voltar()">  
        <br>

    </body>
</html>