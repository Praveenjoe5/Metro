/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.service.PaymentCabService;
import com.tm.metrocab.service.PaymentCabServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This Class is created to proceed with the payment details with the customer details
public class PaymentCabController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                       try  {
                     BankPayment bankpay=new BankPayment();
             RequestCab requestCab=new RequestCab();
             requestCab.setBookingId(request.getParameter("bookid"));
             bankpay.setCardno(request.getParameter("cardno"));
             bankpay.setCardname(request.getParameter("cardname"));
             bankpay.setValidity(request.getParameter("validity"));
             bankpay.setBankName(request.getParameter("bankname"));
             int cv =Integer.parseInt(request.getParameter("cvv"));
             bankpay.setCvv(cv);
     PaymentCabService payService=new PaymentCabServiceImpl();
          List<String> li= payService.makePayment(requestCab,bankpay);
          if(li.isEmpty())
          {
              String ab="PAYMENT INVALID";
             request.setAttribute("result", ab);
               RequestDispatcher rd=request.getRequestDispatcher("fixedbookcab.jsp");
            rd.forward(request, response);
              // Object a=request.getAttribute("result");
              //out.println("payment cannot store");
          }
          else
          {           
              

               request.setAttribute("result", li);
               RequestDispatcher rd=request.getRequestDispatcher("cardetails.jsp");
            rd.forward(request, response);
            
//Iterator itr=li.iterator();
//while(itr.hasNext())
//{
//    
//   out.println(itr.next());
//   out.println("<br>");
//}
         }
        }
        catch(Exception se)
        {
            System.out.println(se);
        } finally {            
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
