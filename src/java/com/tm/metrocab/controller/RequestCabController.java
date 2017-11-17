


//This RequestCabController Servlet is used to get the values from the "requestcab.html"
// inorder to store in the database named:"metro"

package com.tm.metrocab.controller;

import com.tm.metrocab.service.RequestCabService;
import com.tm.metrocab.service.RequestCabServiceImpl;
import com.tm.metrocab.service.CheckAvailService;
import com.tm.metrocab.service.CheckAvailServiceImpl;
import com.tm.metrocab.beans.RequestCab;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestCabController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        PrintWriter out=response.getWriter();
      
         RequestCab requestCab=new RequestCab();
        request.setAttribute("pickuptime", request.getParameter("pickup"));
        try {
           
         requestCab.setCity(request.getParameter("city"));
         requestCab.setService(request.getParameter("service"));
         requestCab.setType(request.getParameter("type"));         
         requestCab.setDate(request.getParameter("date"));
         requestCab.setTime(request.getParameter("time"));
         requestCab.setPlace(request.getParameter("pickup"));
         requestCab.setDestination(request.getParameter("drop"));
         requestCab.setLandMark(request.getParameter("land"));
         requestCab.setCustomerName(request.getParameter("name"));
         requestCab.setCustomerContact(request.getParameter("number"));
         requestCab.setPersonTravel(request.getParameter("person"));
         requestCab.setIdCardType(request.getParameter("idcardtype"));  
         requestCab.setIdCardNo(request.getParameter("idcardno")); 
         
         
         RequestCabService reqService=new RequestCabServiceImpl();
         
          int result= reqService.insertRequest(requestCab);

          
          if(result==1){
              
              out.println("data stored success.......");
              
          }
          else {
              
              out.println("data storage failed sorry....");
              
          }
          
           CheckAvailService checkService=new CheckAvailServiceImpl();
           
           String output=checkService.checkAvail(requestCab);
           
           if(output!=null){
               
            request.setAttribute("result", output);
            RequestDispatcher rd=request.getRequestDispatcher("bookingdisplay.jsp");
            rd.forward(request, response);
      
             }
           else{
               out.println("something wrong in code");
           }
        } finally {            
            out.close();
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
