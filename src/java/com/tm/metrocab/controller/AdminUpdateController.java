/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.AdminUpdate;
import com.tm.metrocab.service.AdminUpdateService;
import com.tm.metrocab.service.AdminUpdateServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This Class is created for update the status,delete customer and view feedback of the customer
public class AdminUpdateController extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AdminUpdate admin=new AdminUpdate();
        try {
            AdminUpdateService adminService=new AdminUpdateServiceImpl();
           admin.setBookingId(request.getParameter("bookid"));
           admin.setStatus(request.getParameter("status"));
           int result=adminService.adminUpdate(admin);
           if(result==1)
           {
               request.setAttribute("result", "your data is updated<br><br><a href='admin.jsp'/><input type='button' value='BACK'/>");
               RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
             
           }
           else
           {
               request.setAttribute("result", "your update is failed<br><br><a href='admin.jsp'/><input type='button' value='BACK'/>");
               RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
             
           }
        }
        catch(Exception se)
        {
            System.out.println(se);
        }
finally {            
            out.close();
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
