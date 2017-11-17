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
import java.sql.Statement;

/**
 *
 * @author TechM
 */
public class CheckAvailDAOImpl implements CheckAvailDAO {
String status="unavailable";
String loc;
String bookId;
String flag="default";
static int count;
static int count1;
int car_id=0,ch;
public int carCount()
{
   return car_id=car_id+1; 
}
//to check availablity of the requested cab and return the booking id generated for the customer
    @Override
    public String checkAvail(RequestCab req) {
       Connection connection=JDBCUtil.getConnection(); 
    
             String location=req.getPlace();
     try{
    Statement st=connection.createStatement(); 
    PreparedStatement ps1=connection.prepareStatement("select booking_id from metro where customer_name=?");
    ps1.setString(1, req.getCustomerName());
    ResultSet rs1=ps1.executeQuery();
    while(rs1.next()){
        bookId=rs1.getString(1);
    }
  
    String qr="select status,location from metro_"+req.getCity()+"1 where status='available' and location='"+req.getPlace()+"' and service='"+req.getService()+"'";
        ResultSet rs=st.executeQuery(qr);
    while(rs.next()){
    status=rs.getString(1);
      loc=rs.getString(2);
    }
     System.out.println(status);
         System.out.println(req.getCity());
         System.out.println(req.getPlace());
         System.out.println(req.getService());
    if(status.equals("available") && location.equals(loc)){
        String bbb="update metro_"+req.getCity()+"1 set booking_id=?,status='available',pickup_date=?,pickup_time=? where car_id=? and status='available' and location=? and service=?";
          PreparedStatement ps=connection.prepareStatement(bbb);
         ps.setString(1, bookId);
        ps.setString(2,req.getDate());
        ps.setString(3,req.getTime());
        ps.setString(5, req.getPlace());
        ps.setString(6,req.getService());
        if(req.getCity().equalsIgnoreCase("delhi"))
        {
            ch=20;
        }
        else
        {
            ch=10;
        }
            
         for(int i=1;i<=ch;i++) {
             int cc=i;
             ps.setInt(4, cc);
              count=ps.executeUpdate();             
              System.out.println(cc);
          if(count==1){
             flag="thank you for searching"; 
             break;
          }
        }
        }
    if(status.equals("unavailable")){ 
        
              flag="thank you for searching <br> sorry no cars available now<br> please try again later";
              PreparedStatement ps2=connection.prepareStatement("delete from metro where booking_id=?");
              ps2.setString(1, bookId);
              ps2.executeUpdate();
              bookId="NOT AVAILABLE";          
        }
     }  
    catch(SQLException se)  {
        System.out.println(se);
    }
        return ("<br>"+"Availablity of your request: "+status+"<br>"+"Please note your booking ID given below:<br>"+"your booking id:"+bookId+"<br>"+flag);
}  
    }

