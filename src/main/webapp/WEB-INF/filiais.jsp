<%-- 
    Document   : produtos
    Created on : 13/10/2019, 14:55:35
    Author     : Deise
--%>

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
        <form method="POST" action="Servlet">
            <input type="hidden" name="id_filial" value="${filial.id_filial}"/>
            <label>Id</label><input type="text" disabled name ="id_filial"value="${filial.id_filial}"/><br>
            <label>CNPJ</label><input type="text" name ="cnpj_filial"value="${filial.cnpj_filial}"/><br>
            <label>Nome</label><input type="text" name ="nome_filial" value="${filial.nome_filial}"/><br>
            <label>Desc</label><input type="text" name ="desc_filial" value="${filial.desc_filial}"/><br>
            <label>Cidade</label><input type="text" name ="cidade_filial" value="${filial.cidade_filial}"/><br>
            <label>Estado</label><input type="text" name ="estado_filial"value="${filial.estado_filial}"/><br>
                
            <input type="submit" value="enviar"/>
                <%--<input type="submit" value="Salvar" onclick="alert('${mensagem}')"><a href="produto.jsp"></a> --%> 
            <input type="button" value="Sair" onClick="Voltar()">       
        </form>
        
        <br>
        <h4>Filias Cadastrados</h4>
        <table border="1">
            <tr>
            <th>Id</th>
            <th>CNPJ</th>
            <th>Nome</th>
            <th>Desc</th>
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
                    
                    <td><a href=Servlet?acao=editar&id=${c.id_filial}>Editar</a></td>
                    <td><a href=Servlet?acao=excluir&id=${c.id_filial}>Excluir</a></td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
