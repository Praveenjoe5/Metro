/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.service.CancelCabService;
import com.tm.metrocab.service.CancelCabServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This Class is created to cancel the cab who booked the cab
public class CancelCabController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try  {
           // out.println("<html><body background=ab4.jpg style='width:1600;height:800;'>");
             RequestCab requestCab=new RequestCab();
    requestCab.setBookingId(request.getParameter("cancel"));
          CancelCabService canService=new CancelCabServiceImpl();
          int result= canService.cancelRequest(requestCab);
String a="YOUR BOOKING IS CANCELLED...<br>YOUR PAYMENT WILL BE REFUNDED WITHIN A WEEK";
String b="SORRY CANNOT CANCEL YOUR BOOKING NOW<BR>PLEASE TRY AGAIN LATER";
          if(result==1){
            request.setAttribute("result", a);
            RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
              // out.println("<h3 style='color:white;'>YOUR BOOKING IS CANCELLED...<br>YOUR PAYMENT WILL BE REFUNDED WITHIN A WEEK</h3><br><br><br>");
          }else 
          {
               request.setAttribute("result", b);
               RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
             // out.println("<h3 style='color:white';font-size:'250px'>SORRY CANNOT CANCEL YOUR BOOKING NOW<BR>PLEASE TRY AGAIN LATER</h3>");
          }
          
         // out.println("</body></html>");
        }
        catch(Exception se)
        {
            System.out.println(se);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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