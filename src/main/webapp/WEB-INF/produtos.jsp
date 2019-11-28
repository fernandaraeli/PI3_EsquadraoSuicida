<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        
                <script type="text/javascript">
            
            function Alerta(){
               
                var nome = form.Nome.value;
                var quant = form.quantidade.value;
                var preco = form.preco.value;
                var filial = form.filial.value; 
               
                if(nome == ""){                
                    alert("Preencha o Nome de Produto");
                    return false;                        
                }
                else if(quant == ""){
                    alert("Preencha a Qunatidade do Produto");
                    return false;
                }
                else if(preco == ""){
                    alert("Preencha o valor do produto");
                    return false;
                }
                else if(filial == ""){
                   alert("Preencha o Id da Filial");
                   return false;
                }
                alert("Cadastro salvo com sucesso!");
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
                 <a class="nav-link" href="ControladorPrincipal?menu=Relatorios&acao=default&selecao=default">Relatórios</a>
           </strong>
        </li>
    </ul>
  </div>
  </nav>
        <form name="form" method="POST" action="produtoControle">
            
            <div class="form-row"> 
                
                <div class="form-group col-md-1">            
                </div>
                
                <div class="form-group col-md-1">
                    <input type="hidden" name="id" value="${produto.id}"/>
                    <label>Id</label>
                    <input type="text" disabled name="id_filial" class="form-control" type="hidden" name="id"  value="${produto.id}"/>
                </div>
                     
                <div class="form-group col-md-5">
                     <label for="inputPassword4">Nome do Produto</label>
                     <input type="text" class="form-control" placeholder="Nome do Produto" name="Nome"  value="${produto.nome}" required/>
                </div>             
            </div>
                     
            
            <div class="form-row"> 
                
                <div class="form-group col-md-1">            
                </div>
                
                                 
                <div class="form-group col-md-2">
                     <label for="inputPassword4">Quantidade</label>
                     <input type="text" class="form-control" placeholder="Estoque" name="quantidade" min="1" value="${produto.quantidade}" required/>
                </div>
                
                <div class="form-group col-md-2">
                     <label for="inputPassword4">Preço</label>
                     <input type="text" class="form-control" placeholder="R$" name="preco" min="1" value="${produto.preco}" required/>
                </div>
                
                 <div class="form-group col-md-2">
                     <label for="inputPassword4">Filial</label>
                     <input type="text" class="form-control" placeholder="Escolha Filial" name="filial" value="${produto.filial}" required/>
                </div>
                
            </div>
            <br>
              
              <div class="form-row">
                   <div class="form-group col-md-1">            
                    </div> 
                        <button type="submit" class="btn btn-success" onclick="return Alerta()">Cadastrar</button>&nbsp
                        <button type="reset" class="btn btn-primary">Limpar</button>&nbsp;
                        <a href="produtoControle?acao=voltar" class="btn btn-danger">Voltar</a> 
              </div>
                                   

            
        </form>
        
        
        
        
        
        <!--
        <form method="POST" action="produtoControle">
                     <label>ID:</label><input type="text" disabled name="id"><br/>
                     <label>Nome:</label><input type="text" name="Nome"><br/>
                     <label>Quantidade:</label><input type="text" name="quantidade"><br/>
                     <label>Preço:</label><input type="text" name="preco"><br/>
                     <label>Filial:</label><input type="text" name="filial"><br/>
                     
                     <input type="submit" value="Salvar" onclick="Alerta()">
                     <input type="reset" value="Limpar">
                     <a href=produtoControle?acao=voltar><input type="button" value="Voltar"></a>      
        </form>
                
         -->    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
                 
                
                
    </body>
</html>
