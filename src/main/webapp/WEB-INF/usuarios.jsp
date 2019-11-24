<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        
        <script type="text/javascript">
            
            function Alerta(){
                alert("Cadastro Atualizado!");
            }
        </script>
    </head>
    <body>
       
        <h1>Cadastro de Usuários</h1>
        <hr>
        
        
            
        <form method="POST" action="usuarioControle">
            
             <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
                     <div class="form-group col-md-1">
                        <input type="hidden" name="id_usuario" value="${user.id_usuario}"/>
                        <label>Id</label>
                        <input type="text" disabled class="form-control" name="id_usuario" value="${user.id_usuario}"/>                      
                     </div>
                     
                      <div class="form-group col-md-3">
                        <label for="inputPassword4">Nome do Usuário</label>
                        <input type="text" class="form-control" placeholder="Usuário" name="nome_usuario" value="${user.nome_usuario}"/>
                      </div>             
             </div> 
                      
            <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
              
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Login de Usuário</label>
                        <input type="text" class="form-control" placeholder="Login de Acesso" name="user" value="${user.user}"/>
                    </div>
                    
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Senha de Usuário</label>
                        <input type="password" class="form-control" placeholder="Senha de Acesso" name="senha"value="${user.senha}"/>
                    </div> 
             </div> 
            
             <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
              
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Filial</label>
                        <input type="text" class="form-control" placeholder="Filial" name="id_filial" value="${user.id_filial}"/>
                    </div>
                    
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Perfil</label>
                        <input type="text" class="form-control" placeholder="Perfil" value="${user.id_perfil}"/>
                    </div> 
             </div> 
            
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" onclick="Alerta()">Cadastrar</button>
            <button type="reset" class="btn btn-primary">Limpar</button>
            <button type="reset" class="btn btn-primary" ><a href=usuarioControle?&acao=Voltar>Voltar</a></button> 
            
        </form>
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
   
    </body>
</html>
