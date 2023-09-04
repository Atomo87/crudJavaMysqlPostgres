/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author user
 */
public class clienteCreateAndFind extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet clienteCreateAndFind</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet clienteCreateAndFind at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String pesquisa = request.getParameter("buscar");
      
    
      if(pesquisa == null){
          pesquisa = "";    
      }
      
   
        List<Cliente> clientes = ClienteDao.find(pesquisa);
        request.setAttribute("clientes", clientes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
        requestDispatcher.forward(request, response);
      

// processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         boolean gravar = false;
         Cliente cliente = new Cliente();
         cliente.setNome(request.getParameter("nome"));
         cliente.setCpf(request.getParameter("cpf"));
         cliente.setNascimento(request.getParameter("nascimento"));
         cliente.setSituacao(request.getParameter("situacao"));
        try {
            gravar = ClienteDao.create(cliente);
            response.sendRedirect(request.getContextPath()+"/clienteCreateAndFind");
        } catch (ParseException ex) {
        processRequest(request, response);
        }
    
         
          //processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
