/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author techm
 */
public class PaymentCabDAOImpl implements PaymentCabDAO {
Connection con=JDBCUtil.getConnection();
String cost;
String book;
String pick;
String drop,city;
//to  calculate cost of the requested cab
public String costCal() throws SQLException
{
    
   PreparedStatement ps4=con.prepareStatement("select pickup_place,destination from metro where booking_id=?");
              ps4.setString(1, book);
              ResultSet rs3=ps4.executeQuery();
              if(rs3.next())
              {
                  pick=rs3.getString(1);
                  drop=rs3.getString(2);
              }
  
              PreparedStatement ps2=con.prepareStatement("select cost from metro_"+city+"_cost where pickup_place=? and destination=?");
              ps2.setString(1, pick);
              ps2.setString(2,drop);
              ResultSet rs2=ps2.executeQuery();
              if(rs2.next())
              {
                cost=rs2.getString(1);  
              }
              return cost;
}

// to make payment by the customer and to return the cab details to the customer if successfully details
    public List makePayment(RequestCab req, BankPayment bank) {
        List<String> li=new ArrayList<String>();
        int flag;
        String carid=null;
        String pickup=null;
        try{
              PreparedStatement ps7=con.prepareStatement("select city from metro where booking_id=?");
            ps7.setString(1, req.getBookingId());
            ResultSet rs7=ps7.executeQuery();
            if(rs7.next())
            {
               city=rs7.getString(1); 
            }
        PreparedStatement ps=con.prepareStatement("insert into payment values(?,?,?,?,?,?,?)");
        String b=req.getBookingId();
        ps.setString(1,b);
        ps.setString(2, bank.getCardno());
        ps.setString(3, bank.getCardname());
        ps.setString(4, bank.getValidity());
        ps.setInt(5, bank.getCvv());
        ps.setString(6,bank.getBankName());
        ps.setString(7,"paid");
        flag=ps.executeUpdate();
            System.out.println("values inserted in payment");
         if(flag==1)
        {
            book=req.getBookingId();            
          // Statement st=con.createStatement();
           PreparedStatement ps3=con.prepareStatement("select car_id,pickup_time from metro_"+city+"1 where booking_id=?");
           ps3.setString(1, book);
            ResultSet rs=ps3.executeQuery();
                 System.out.println(book);
                 if(rs.next())
              {
                  pickup=rs.getString(2);
                carid=rs.getString(1);
              }  
                 System.out.println(carid);
              PreparedStatement ps1=con.prepareStatement("select * from metro_"+city+"_cardetails where car_id=?");
              ps1.setString(1,carid);
              ResultSet rs1=ps1.executeQuery();
              if(rs1.next())
              {
                  li.add("car id: "+rs1.getString(1));
                  li.add("cab number: "+rs1.getString(2));
                  li.add("driver name: "+rs1.getString(3));
                  li.add("employee number: "+rs1.getString(4));
                  li.add("cab color: "+rs1.getString(5));
                  li.add("driver mobile number: "+rs1.getString(6));  
                  li.add("your booking cost"+costCal());
                  li.add("your pickup time: "+pickup);
               }
             PreparedStatement ps5=con.prepareStatement("update metro_"+city+"1 set status='unavailable' where booking_id=?");
           ps5.setString(1, book);
            ps5.executeUpdate();
            PreparedStatement ps6=con.prepareStatement("update metro set status='paid' where booking_id=?");
            ps6.setString(1, book);
            ps6.executeUpdate();
        }
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
      return li;  
    }


}
