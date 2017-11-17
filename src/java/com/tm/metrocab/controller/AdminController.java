/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.AdminLogin;
import com.tm.metrocab.util.JDBCUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This AdminController Class is used to authenticate the admin username and password
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //This method processRequest is called by doPost() method
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con=JDBCUtil.getConnection();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AdminLogin admin=new AdminLogin();
        
        
      
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("password"));
       
//verifying the username and password of Admin
             if(admin.getUsername().equals("admin") && admin.getPassword().equals("admin123"))
        {
            //if true create session which holds the data until the session gets invalidate
                
                HttpSession session=request.getSession();
                
                System.out.println(session);
                System.out.println(session.getId());
                session.setAttribute("username",admin.getUsername());
                session.setAttribute("password",admin.getPassword());
                session.setAttribute("id",session.getId());
                RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response); 
        }
             else
             {
             
                 String b="INVALID USERNAME OR PASSWORD <BR>PLEASE TRY AGAIN LATER";
               request.setAttribute("result", b);
               RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
               
             }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
