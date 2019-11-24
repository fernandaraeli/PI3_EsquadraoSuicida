<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        
                <script type="text/javascript">
            
            funcition validaProd(){
               
               var nome = validaProd.Nome.value;
               var quant = validaProd.quantidade.value;
               var preco = validaProd.preco.value;
               var filial = validaProd.filial.value; 
               
               if(nome == ""){                
                    alert("Preencha o Nome de Produto");
                    validaProd.Nome.focus();
                    return false;                        
               }
               else if(quant == ""){
                    alert("Preencha a Qunatidade do Produto");
                    validaProd.quantidade.focus();
                    return false;
               }
               else if(preco == ""){
                    alert("Preencha o valor do produto");
                    validaProd.preco.focus();
                    return false;
               }
               else if(filial == ""){
                   alert("Preencha o Id da Filial");
                   validaProd.filial.focus();
                   return false;
               }
               else {
                   alert("Cadastro Realizado com Sucesso.");
                   return true;
               }
               
               
            }
            
            
            function Alerta(){
                alert("Cadastro salvo com sucesso!");
            }
            
            
            
            
            </script>        
    </head>
    <body>
        <h1>Produto</h1>
        <hr/>
        
        <form name="validaProd" method="POST" action="produtoControle">
            
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
                     <input type="text" class="form-control" placeholder="Nome do Produto" name="Nome"  value="${produto.nome}"/>
                </div>             
            </div>
                     
            
            <div class="form-row"> 
                
                <div class="form-group col-md-1">            
                </div>
                
                                 
                <div class="form-group col-md-2">
                     <label for="inputPassword4">Quantidade</label>
                     <input type="text" class="form-control" placeholder="Estoque" name="quantidade value="${produto.quantidade}"/>
                </div>
                
                <div class="form-group col-md-2">
                     <label for="inputPassword4">Preço</label>
                     <input type="text" class="form-control" placeholder="R$" name="preco" value="${produto.preco}"/>
                </div>
                
                 <div class="form-group col-md-2">
                     <label for="inputPassword4">Filial</label>
                     <input type="text" class="form-control" placeholder="Escolha Filial" name="filial" value="${produto.filial}"/>
                </div>
                
            </div>
            
                
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" onclick="Alerta()">Cadastrar</button>
            <button type="reset" class="btn btn-primary">Limpar</button>
            <button type="reset" class="btn btn-primary" ><a href=produtoControle?acao=voltar>Voltar</a></button> 
            
            
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
