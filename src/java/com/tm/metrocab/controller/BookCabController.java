/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.service.BookCabService;
import com.tm.metrocab.service.BookCabServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This Class is created for checking the valid customer to book a cab and also redirect the page according the requested bank by the customer
public class BookCabController extends HttpServlet {

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
      
               try  {
                     BankPayment bankpay=new BankPayment();
             RequestCab requestCab=new RequestCab();
    requestCab.setBookingId(request.getParameter("bookid"));
    bankpay.setBankName(request.getParameter("bankname"));
    bankpay.setCard(request.getParameter("card"));
     BookCabService bookService=new BookCabServiceImpl();
          int result= bookService.checkRequest(requestCab);
          if(result==1){
              
             if(bankpay.getBankName().equalsIgnoreCase("axis bank"))
              {
                   request.setAttribute("bookingId", requestCab.getBookingId());
                  request.setAttribute("bankname", bankpay.getBankName());
                  RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");  
                  rd.forward(request, response);
                
              }
             if(bankpay.getBankName().equalsIgnoreCase("hdfc bank"))
             {
                  request.setAttribute("bookingId", requestCab.getBookingId());
                  request.setAttribute("bankname", bankpay.getBankName());
                  RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");  
                  rd.forward(request, response);
                 
                 
          }
               if(bankpay.getBankName().equalsIgnoreCase("icici bank"))
              {
                   request.setAttribute("bankname", bankpay.getBankName());
                   request.setAttribute("bookingId", requestCab.getBookingId());
                  RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");  
                  rd.forward(request, response);
                 
              }
          }
          else 
          {
              request.setAttribute("result", "INVALID ID");
               RequestDispatcher rd=request.getRequestDispatcher("fixedbookcab.jsp");
            rd.forward(request, response);
              
          }
        }
        catch(Exception se)
        {
            System.out.println(se);
        }finally {            
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
