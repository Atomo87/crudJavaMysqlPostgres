/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ConexaoPostgres {
   private static String url = "jdbc:postgresql://localhost:5432/crud_servelet";
   private static String user = "postgres";
   private static String password = "postgres";
   
   
   /*
   
   CREATE SEQUENCE id_cliente
   start 1
   increment 1;
   
   
   
   */
   
   
   public static Connection createConnectionPostgres(){
      Connection con = null; 
    
       try {
         Class.forName("org.postgresql.Driver");
         con = DriverManager.getConnection(url,user,password);
           System.out.println("Conection is successful!"); 
           
       } catch (ClassNotFoundException | SQLException e) {
           //
           System.out.println("Erro ao conectar com o postgres" + e.getMessage());
       
       }
       
      
      
      
      return con;
      
   }
    
    
    
    
}
