/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConexaoMysql;
import db.ConexaoPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model.Cliente;

/**
 *
 * @author user
 */
public class ClienteDao implements CRUD{
 private static String sql = "";  
 //private static Connection connection = ConexaoMysql.createConnection();
 private static Connection connection = ConexaoPostgres.createConnectionPostgres();   
    
public static boolean create(Cliente cliente) throws ParseException{
 // sql = "INSERT INTO clientes VALUES(null,?,?,?,?)";

   sql = "INSERT INTO clientes VALUES(nextval('clientes_id_seq'),?,?,?,?)";    
 
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getCpf());
        preparedStatement.setString(3, cliente.getNascimento());
        preparedStatement.setString(4, cliente.getSituacao());
        preparedStatement.executeUpdate();
        System.out.println("-- Correct Insert on Database");
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar dados"+e.getMessage());
        return false;
    }
  
    
}
public static void update(Cliente cliente){
    
    sql = "Update clientes SET nome = ?,cpf = ?,nascimento = ?,situacao = ?  WHERE id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getCpf());
        preparedStatement.setString(3, cliente.getNascimento());
        preparedStatement.setString(4, cliente.getSituacao());
        preparedStatement.setInt(5, cliente.getId());
        preparedStatement.executeUpdate();
        System.out.println("-- Correct Update on Database");
  
    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar dados"+e.getMessage());
     
    }
    
    
    
}
public static void delete(int id){
   sql = "Delete from clientes where id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        System.out.println(" Correct delete cliente");
        
        
    } catch (Exception e) {
            System.out.println(" Error to delete cliente" + e.getMessage());
    }
   
}
public static Cliente findClienteByid(int id){
    
    sql = String.format("Select * from clientes where id = %d",id);

      
    try {
        Cliente cliente = new Cliente();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        
        while(resultset.next()){
         cliente.setId(resultset.getInt("id"));
         cliente.setNome(resultset.getString("nome"));
         cliente.setCpf(resultset.getString("cpf"));
         cliente.setNascimento(resultset.getDate("nascimento").toString());
         cliente.setSituacao(resultset.getString("situacao"));
        }
        
        return cliente;
        
    } catch (SQLException e) {
           System.out.println("Erro ao retornar cliente"+e.getMessage());
           return null;
        
        
    }
    


}
public static List<Cliente> find(String pesquisa){

    sql = String.format("Select * from  clientes WHERE nome like '%s%%' OR cpf LIKE '%s%%' ",pesquisa,pesquisa);
    List<Cliente> clientes = new ArrayList<>();
      
    try {
        Statement statement = connection.createStatement();
        
        ResultSet resultset = statement.executeQuery(sql); 
        while(resultset.next()){
         Cliente cliente = new Cliente();
         cliente.setId(resultset.getInt("id"));
         cliente.setNome(resultset.getString("nome"));
         cliente.setCpf(resultset.getString("cpf"));
         cliente.setNascimento(resultset.getDate("nascimento").toString());
         cliente.setSituacao(resultset.getString("situacao"));
         clientes.add(cliente);
            
        }
        
    } catch (SQLException e) {
           System.out.println(e.getMessage());
           return null;
        
        
    }
    
return clientes;


}
}
