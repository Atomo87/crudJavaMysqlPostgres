/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author user
 */
public interface CRUD {
    public static boolean create(Cliente cliente){ return false;}
    public static void update(Cliente cliente){}
    public static void delete(int id){}
    public static Cliente findClienteByid(int id){return null;}
    public static List<Cliente> find(String pesquisa){return null;}
}
