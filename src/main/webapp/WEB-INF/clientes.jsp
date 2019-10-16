<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h2 style=" color: red">${mensagem}</h2>
        <h1>Clientes</h1>
        <hr>
        <script type="text/javascript">
            function Voltar(){
                location.href = 'index.html'
            }
            </script>
        
        <form method="POST" action="clienteControle">
                     <input type="hidden" name="id" value="${cliente.id}"/>
                     <label>ID:</label><input type="text" disabled name="id" value="${cliente.id}"/><br/>
                     <label>Razão Social:</label><input type="text" name="razao" value="${cliente.razao}"/><br/>
                     <label>CNPJ:</label><input type="text" name="cnpj"value="${cliente.cnpj}"/><br/>
                     <label>Telefone:</label><input type="text" name="telefone" value="${cliente.telefone}"/><br/>
                     <label>E-mail:</label><input type="text" name="email" value="${cliente.email}"/><br/>
                     <label>Endereço:</label><input type="text" name="endereco" value="${cliente.endereco}"/><br/>
                     <label>Complemento:</label><input type="text" name="complemento" value="${cliente.complemento}"/><br/>
                     <label>Número:</label><input type="text" name="numero" value="${cliente.numero}"/><br/>
                     <label>CEP:</label><input type="text" name="cep" value="${cliente.cep}"/><br/>
                     <label>Bairro:</label><input type="text" name="bairro" value="${cliente.bairro}"/><br/>
                     <label>Cidade:</label><input type="text" name="cidade" value="${cliente.cidade}"/><br/>
                     
                     <input type="submit" value="Salvar" onclick="alert('${mensagem}')">
                     <input type="reset" value="Limpar">
                     <input type="button" value="Sair" onclick="Voltar()"> 
        </form>       
    </body>
</html>
