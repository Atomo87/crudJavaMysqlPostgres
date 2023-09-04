
import db.ConexaoMysql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Teste {
    
    public static void Main (String[] args){
        
        try {
            ConexaoMysql.createConnection();
        } catch (Exception e) {
               System.out.println("Erro ao conectar a base de dados" + e.getMessage());
        }
        
    }
    
    
}
