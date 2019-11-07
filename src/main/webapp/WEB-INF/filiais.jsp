<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Filiais</title>
    </head>
        <script type="text/javascript">            
            function Alerta(){
                alert('${mensagem}');
            }
            </script>
    <body>

        <h2 style=" color: red">${mensagem}</h2>
        <h1>Filiais</h1>
        <hr>
        <form method="POST" action="filialControle">
            <input type="hidden" name="id_filial" value="${filial.id_filial}"/>
            <label>Id</label><input type="text" disabled name ="id_filial"value="${filial.id_filial}"/><br>
            <label>CNPJ</label><input type="text" name ="cnpj_filial"value="${filial.cnpj_filial}"/><br>
            <label>Nome</label><input type="text" name ="nome_filial" value="${filial.nome_filial}"/><br>
            <label>Descrição</label><input type="text" name ="desc_filial" value="${filial.desc_filial}"/><br>
            <label>Cidade</label><input type="text" name ="cidade_filial" value="${filial.cidade_filial}"/><br>
            <label>Estado</label><input type="text" name ="estado_filial"value="${filial.estado_filial}"/><br>
            
            <input type="submit" value="Salvar" onclick="Alerta()">
            <input type="reset" value="Limpar">
            <a href=filialControle?acao=voltar><input type="button" value="Voltar"></a> 
                      
        </form>
       
    </body>
</html>
