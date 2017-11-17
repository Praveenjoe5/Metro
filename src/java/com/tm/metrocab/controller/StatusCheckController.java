/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.controller;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.service.StatusCheckService;
import com.tm.metrocab.service.StatusCheckServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This class is created to make customers to check the availablity and cardetails(if cab is booked)
public class StatusCheckController extends HttpServlet {

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
    String cost,message;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
               try  {
             RequestCab requestCab=new RequestCab();
    requestCab.setBookingId(request.getParameter("status"));
          StatusCheckService statusService=new StatusCheckServiceImpl();
          String stat=request.getParameter("status");
          if(stat==null)
          {
              requestCab.setBookingId(request.getParameter("details"));
              
            List list=statusService.getCarDetails(requestCab);
            if(list.isEmpty()){
                message="SORRY NO DETAILS AVAILABLE FOR YOU<br>CHECK THIS AFTER BOOKING YOUR CAB<br><br><a href='status.html'><input type='submit' value='BACK'/></a>";
                 request.setAttribute("result", message);
               RequestDispatcher rd=request.getRequestDispatcher("fixed.jsp");
            rd.forward(request, response);
       
            }
            else{
                  request.setAttribute("result", list);
               RequestDispatcher rd=request.getRequestDispatcher("cardetails.jsp");
            rd.forward(request, response);

            }
          }
          else if(stat!=null)
          {
          int result= statusService.checkStatus(requestCab);
int res=statusService.checkCost(requestCab);
cost="ESTIMATE FOR YOUR RIDE: "+res+"<br>";

          if(result==1){
              message="STATUS: AVAILABLE";
             
          }
          else 
          {
              message="ENTER THE CORRECT BOOKING ID/REQUESTED CAB ALREADY HIRED<BR>PLEASE TRY AGAIN LATER...<br><br><a href='status.html'><input type='submit' value='BACK'/></a>";
          
          }
          request.setAttribute("result", message);
          request.setAttribute("cost", cost);
               RequestDispatcher rd=request.getRequestDispatcher("statusdisp.jsp");
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
