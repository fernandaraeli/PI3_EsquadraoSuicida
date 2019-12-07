<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
         <script type="text/javascript">
            
            function Alerta(){
                alert("Cadastro Realizado Com Sucesso!");
            }
            </script>
            
        <nav class="navbar navbar-expand-lg">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">&nbsp;</div>
        </nav> 
            
      <form name="form" method="POST" action="clienteControle" class="form-sign">
                
                <div class="form-row">
                    
                    <div class="form-group col-md-1">            
                    </div>                    
                     <div class="form-group col-md-1">
                        <input type="hidden" name="id" value="${cliente.id}"/>
                        <label>Id</label>
                        <input type="text" disabled name="id" class="form-control" value="${cliente.id}"/>                      
                     </div>
                     
                      <div class="form-group col-md-3">
                        <label for="inputPassword4">CNPJ</label>
                        <input type="text" class="form-control" placeholder="99.999.999/9999-99" name="cnpj" value="${cliente.cnpj}" required=""/>
                      </div>             
                </div>
                      
                                 
                <div class="form-row"> 
                    
                     <div class="form-group col-md-1">
            
                    </div>
                     <div class="form-group col-md-4">
                        <label for="inputPassword4">Nome do Cliente</label>
                        <input type="text" name="razao" class="form-control" placeholder="Nome da Empresa" value="${cliente.razao}" required/>
                      </div> 
                    
                </div>    
                      
                <div class="form-row"> 
                    
                    <div class="form-group col-md-1">
            
                    </div>
                    
                     <div class="form-group col-md-1">
                        <label for="inputPassword4">Telefone</label>
                        <input type="number" class="form-control" placeholder="(99)9999-9999" name="telefone" value="${cliente.telefone}"/>
                      </div> 
                    
                      <div class="form-group col-md-3">
                        <label for="inputPassword4">Email</label>
                        <input type="text" name="email" class="form-control" placeholder="exemplo@exemplo.com" value="${cliente.email}"/>
                      </div> 
                      
                </div>    
               <div class="form-row"> 
                    
                    <div class="form-group col-md-1">
            
                    </div>
                    
                     <div class="form-group col-md-3">
                        <label for="inputPassword4">Endereço</label>
                        <input type="text" class="form-control" placeholder="Rua..." name="endereco"  value="${cliente.endereco}"/>
                      </div> 
                    
                      <div class="form-group col-md-1">
                        <label for="inputPassword4">Número</label>
                        <input type="number" name="numero" class="form-control" placeholder="123 ..." value="${cliente.numero}"/>
                      </div> 
                      
                </div>  
                      
                  <div class="form-row"> 
                    
                    <div class="form-group col-md-1">
            
                    </div>
                    
                     <div class="form-group col-md-3">
                        <label for="inputPassword4">Complemento</label>
                        <input type="text" class="form-control" placeholder="Complemento" name="complemento" value="${cliente.complemento}"/>
                      </div> 
                    
                      <div class="form-group col-md-1">
                        <label for="inputPassword4">Cep</label>
                        <input type="numbervds"  class="form-control" placeholder="99999-999" name="cep" value="${cliente.cep}" required/>
                      </div> 
                      
                </div>  
                      
                  <div class="form-row"> 
                    
                    <div class="form-group col-md-1">
            
                    </div>
                    
                     <div class="form-group col-md-2">
                        <label for="inputPassword4">Bairro</label>
                        <input type="text" class="form-control" placeholder="Bairro" name="bairro" value="${cliente.bairro}"/>
                      </div> 
                    
                      <div class="form-group col-md-2">
                        <label for="inputPassword4">Cidade</label>
                        <input type="text"  class="form-control" placeholder="Cidade" name="cidade" value="${cliente.cidade}" required/>
                      </div>                      
                </div>
                <br>
              
              <div class="form-row">
                   <div class="form-group col-md-1">            
                    </div> 
                        <button type="submit" class="btn btn-success" onclick="return Alerta()">Salvar</button>&nbsp
                        <button type="reset" class="btn btn-primary">Limpar</button>&nbsp;
                        <a href="clienteControle?acao=voltar" class="btn btn-danger">Voltar</a> 
              </div>
            </form> 
                      
                      
       
             <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                           
    </body>
</html>
