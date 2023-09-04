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
    <a class="navbar-brand" href="/CrudWithServelts"> <i class="fas fa-arrow-circle-left"></i></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
       
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Digite nome ou CPF" aria-label="buscar">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
        
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <hr>
                    <h3>Clientes Cadastrados</h3>
                    <hr>
                    <table class="table">
                     <thead>
                <tr><th>Id</th> <th>Nome</th><th>CPF</th><th>Nascimento</th><th>Situacao</th><th>Operação</th></tr> 
                        </thead>
                        <tbody>
                            
                            <c:forEach items="${clientes}" var="cliente">
                            <tr>
                            <td>${cliente.id}</td>
                             <td>${cliente.nome}</td>  
                             <td>${cliente.cpf}</td>
                              <td>${cliente.nascimento}</td>
                             <td>${cliente.situacao}</td>
                             <td class="text-center">
                                 <a href="clienteDestroy?clienteId=${cliente.id}"><i class="fas fa-trash-alt text-danger"></i></a>&nbsp;&nbsp;
                                 <a href="clienteAtualizar?clienteId=${cliente.id}">  <i class="fas fa-edit text-info"></i> </a>
                              
                             </td>
                                
                                </tr>
                            </c:forEach>
                            
                        </tbody>
                        
                        
                        
                    </table>
    

                </div>
                
                
            </div>
        
        </div>
        
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>
