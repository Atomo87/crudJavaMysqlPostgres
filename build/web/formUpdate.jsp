<%-- 
    Document   : lista
    Created on : 03/09/2023, 19:38:06
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" />    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="clienteCreateAndFind"> <i class="fas fa-arrow-circle-left"></i></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
       
      </ul>
     
    </div>
  </div>
</nav>
        
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <hr>
                    <h3>Atualizar Cliente</h3>
                    <hr>
           
        <form action="clienteAtualizar" method="POST"> 
            <input type="hidden" name="id" value="${cliente.id}" />
        <div class="form-group mb-3">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome" value="${cliente.nome}" aria-describedby="nomeHelp">
        </div>

        <div class="form-group mb-3">
        <label for="cpf">CPF(Apenas numeros)</label>
        <input value="${cliente.cpf}" type="text" maxlength="11" class="form-control" name="cpf" id="cpf">
        </div>

        <div class="form-group mb-3">
        <label for="nascimento">Data de nascimento</label>
        <input value="${cliente.nascimento}" type="date" class="form-control" name="nascimento" id="nascimento">

        </div>

        <div class="form-group mb-3">
        <label for="situacao">Status</label>
        <select class="form-control mb-2" id="situacao" name="situacao">
            
        <option ${cliente.situacao == 1 ? "selected text when true" : "text when false"} value="1">Ativo</option>
        <option ${cliente.situacao == 0 ? "selected text when true" : "text when false"}  value="0">Inativo</option> 
        </select>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>  
        <button type="reset" class="btn btn-secondary">Limpar Formulario</button> 

        </form>
 
                </div>
                
                
            </div>
        
        </div>
        
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>
