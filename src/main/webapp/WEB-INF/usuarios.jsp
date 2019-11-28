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
                var nome = form.nome_usuario.value;
                var login = form.user.value;
                var senha = form.senha.value;
                var filial = form.id_filial.value;
                var perfil = form.perfil.value;
                
                if(nome == ""){
                    alert('Preencha o nome de usuário');
                    return false;
                }else if(login == ""){
                    alert('Preencha um login');
                    return false;
                }else if(senha == ""){
                    alert('Preencha uma senha')
                    return false;
                }else if(filial == ""){
                    alert('Preencha uma filial');
                    return false;
                }else if(perfil == ""){
                    alert('Preencha um perfil');
                    return false;
                }
                alert('Sucesso!');
            }
        </script>
    </head>
    <body>
       
     
             <nav class="navbar navbar-expand-lg navbar-light bg-light ">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        
        
      <!--MENUS-->  
      <li class="nav-item">
         <strong> 
             <a class="nav-link" href="main.jsp">
                 <img src="imagem/logoHome.jpg" alt="70" height="22"/></a>
         </strong>
      </li>

      <li class="nav-item">
         <strong> 
             <a class="nav-link" href="clienteControle">Clientes</a>
         </strong>
      </li>
      
       <li class="nav-item">
         <strong> 
        <a class="nav-link" href="filialControle">Filial</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="produtoControle">Produtos</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="usuarioControle">Usuários</a>
           </strong>
      </li>
      
        <li class="nav-item">
           <strong>
               <a class="nav-link" href="ControladorPrincipal?menu=NovaVenda&acao=default">Nova Venda</a>
        </strong>
      </li>
      
        <li class="nav-item">
           <strong>
                <a class="nav-link" href="ControladorPrincipal?menu=FaturamentoDiario&acao=default">Relatórios</a>
           </strong>
        </li>
    </ul>
      
      
      
 
  </div>
</nav>
        
        
            
        <form name="form" method="POST" action="usuarioControle">
            
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
                        <input type="text" class="form-control" placeholder="Usuário" name="nome_usuario" value="${user.nome_usuario}" required/>
                      </div>             
             </div> 
                      
            <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
              
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Login de Usuário</label>
                        <input type="text" class="form-control" placeholder="Login de Acesso" name="user" value="${user.user}" required/>
                    </div>
                    
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Senha de Usuário</label>
                        <input type="password" class="form-control" placeholder="Senha de Acesso" name="senha"value="${user.senha}" requires/>
                    </div> 
            </div> 
            
            <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
              
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Filial</label>
                        <input type="text" class="form-control" placeholder="Filial" name="id_filial" value="${user.id_filial}"required/>
                    </div>
                    
                    <div class="form-group col-md-2">
                        <label for="inputPassword4">Perfil</label>
                        <input type="text" class="form-control" placeholder="Perfil" name="perfil" value="${user.id_perfil}" required/>
                    </div> 
            </div> 
            
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" onclick="return Alerta()">Cadastrar</button>
            <button type="reset" class="btn btn-primary">Limpar</button>
            
            <!--
            <button type="reset" class="btn btn-primary" ><a href=usuarioControle?&acao=Voltar>Voltar</a></button> 
            -->
        </form>
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
   
    </body>
</html>
