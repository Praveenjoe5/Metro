/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raghuram
 */
public class CancelBookDAOImpl implements CancelBookDAO{
int op;
String city;
//to cancel the request with the valid booking id 
    @Override
    public int cancelRequest(RequestCab req) {
     Connection connection=JDBCUtil.getConnection();   {
     try{
           PreparedStatement ps7=connection.prepareStatement("select city from metro where booking_id=?");
            ps7.setString(1, req.getBookingId());
            ResultSet rs7=ps7.executeQuery();
            if(rs7.next())
            {
               city=rs7.getString(1); 
            }
          PreparedStatement ps=connection.prepareStatement("update metro set status='cancelled' where booking_id=?");
           ps.setString(1, req.getBookingId());
            int op1=ps.executeUpdate();
           PreparedStatement ps1=connection.prepareStatement("update metro_"+city+"1 set status='available',booking_id=null,pickup_date=null,pickup_time=null where booking_id=? and status='unavailable'"); 
           ps1.setString(1,req.getBookingId());
     int op2=ps1.executeUpdate();
     op=op1+op2;
     if(op==2){
         op=1;
     }     
     }
     catch(SQLException se)
     {
         System.out.println(se);
     }
    }
     return op;
    }
}