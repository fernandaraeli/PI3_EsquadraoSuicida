<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Filiais</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
        <script type="text/javascript">  
            
            
            function 
            
            
            
            function Alerta(){
                alert("Cadastro Realizado Com Sucesso!");
            }
            </script>
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
        
        
        <form method="POST" action="filialControle">
          
            
              <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
                     <div class="form-group col-md-1">
                        <input type="hidden" name="id_filial" value="${filial.id_filial}"/>
                        <label>Id</label>
                        <input type="text" disabled name="id_filial" class="form-control" value="${filial.id_filial}"/>
                     </div>
                     
                      <div class="form-group col-md-3">
                        <label for="inputPassword4">CNPJ</label>
                        <input type="text" class="form-control" placeholder="99.999.999/9999-99" name ="cnpj_filial" value="${cliente.cnpj}"/>
                      </div>             
              </div>
                      
              <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
               
                      <div class="form-group col-md-4">
                        <label for="inputPassword4">Nome da Filial</label>
                        <input type="text" class="form-control" placeholder="Nome da Filial" name ="nome_filial" value="${filial.nome_filial}"/>
                      </div>             
              </div> 
                <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>                    
               
                      <div class="form-group col-md-4">
                        <label for="inputPassword4">Descrição da Filial</label>
                        <input type="text" class="form-control" placeholder="Filial ..." name ="desc_filial" value="${filial.desc_filial}"/>
                      </div>             
              </div> 
                      
                      
              <div class="form-row">                    
                    <div class="form-group col-md-1">            
                    </div>         
                     
                    <div class="form-group col-md-3">
                        <label for="inputPassword4">Cidade</label>
                        <input type="text" class="form-control" placeholder="Nome da Cidade" name ="cidade_filial" value="${filial.cidade_filial}"/>
                    </div>  
                    
                     <div class="form-group col-md-1">
                        <label for="inputPassword4">Estado</label>
                        <input type="text" class="form-control" placeholder="UF" name ="estado_filial"value="${filial.estado_filial}"/>
                    </div> 
              </div>
                    
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <button type="submit" class="btn btn-primary" onclick="Alerta()">Cadastrar</button>
                 <button type="reset" class="btn btn-primary">Limpar</button>
                 <!--
                 <button type="reset" class="btn btn-primary" ><a href=filialControle?acao=voltar>Voltar</a></button>         
                 -->
            
            
        </form>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
</html>
