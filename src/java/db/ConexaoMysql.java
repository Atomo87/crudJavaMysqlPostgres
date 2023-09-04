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
public class ConexaoMysql {
    private static final String url = "jdbc:mysql://localhost:3306/crud_servelet";
    private static final String user = "root";
    private static final String password = "";
    
    
    public static Connection createConnection(){
            Connection conn = null;
            
       try {
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(url,user,password);
            
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println("Erro de conexao" + e.getMessage());
            
        }
            
         
                   
                   return conn;
             
      
    }
    
    
}
