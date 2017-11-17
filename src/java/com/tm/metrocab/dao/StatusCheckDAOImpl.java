/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

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
public class StatusCheckDAOImpl implements StatusCheckDAO{
Connection con=JDBCUtil.getConnection();
String stat,st,city;
int flag,carid;
String pick,p;
String drop;
int cost;
 List li=new ArrayList();
 //to check the status of the requested cab
    public int checkStatus(RequestCab req) {
        
        try{
             PreparedStatement ps7=con.prepareStatement("select city from metro where booking_id=?");
            ps7.setString(1, req.getBookingId());
            ResultSet rs7=ps7.executeQuery();
            if(rs7.next())
            {
               city=rs7.getString(1); 
            }
            System.out.println(city);
        String book=req.getBookingId();
        String q1="select status from metro_"+city+"1 where booking_id=?";
        PreparedStatement ps=con.prepareStatement(q1);
        ps.setString(1, book);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
           stat=rs.getString(1); 
        }
        if(stat.equals("available"))
        {
            flag=1;
        }
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
    return flag;
    }
    // to get the car details for sucesfully booked cab
    public List getCarDetails(RequestCab req)
    {
       
        try{
             PreparedStatement ps7=con.prepareStatement("select city from metro where booking_id=?");
            ps7.setString(1, req.getBookingId());
            ResultSet rs7=ps7.executeQuery();
            if(rs7.next())
            {
               city=rs7.getString(1); 
            }
        String book=req.getBookingId();
        String q2="select car_id,status,pickup_time from metro_"+city+"1 where booking_id=?";
        PreparedStatement ps3=con.prepareStatement(q2);
        ps3.setString(1, book);
        ResultSet rs3=ps3.executeQuery();
        if(rs3.next())
        {
            carid=rs3.getInt(1);
           st=rs3.getString(2); 
           p=rs3.getString(3);
        }
            System.out.println(carid);
            System.out.println(st);
            System.out.println(p);
        if(st.equals("unavailable"))
        {
            String q3="select * from metro_"+city+"_cardetails where car_id=?";
         PreparedStatement ps4=con.prepareStatement(q3);
         String c=Integer.toString(carid);
         ps4.setString(1,c);
         ResultSet rs4=ps4.executeQuery();
         while(rs4.next())
         {
                    li.add("car id: "+rs4.getString(1));
                  li.add("cab number: "+rs4.getString(2));
                  li.add("driver name: "+rs4.getString(3));
                  li.add("employee number: "+rs4.getString(4));
                  li.add("cab color: "+rs4.getString(5));
                  li.add("driver mobile number: "+rs4.getString(6));
                  li.add("Pickup time "+p);
         }
        }

        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
        return li;
    }
// to check cost for requested cab
    public int checkCost(RequestCab req) {
        try{
        String bookid=req.getBookingId();
        PreparedStatement ps1=con.prepareStatement("select pickup_place,destination from metro where booking_id=?");
       int boo= Integer.parseInt(req.getBookingId());
        ps1.setInt(1, boo);
        ResultSet rs1=ps1.executeQuery();
        if(rs1.next())
        {
            pick=rs1.getString(1);
            drop=rs1.getString(2);
        }
            System.out.println(pick);
            System.out.println(drop);
            String q4="select cost from metro_"+city+"_cost where pickup_place=? and destination=?";
        PreparedStatement ps2=con.prepareStatement(q4);
        ps2.setString(1, pick);
        ps2.setString(2, drop);
        ResultSet rs2=ps2.executeQuery();
        if(rs2.next())
        {
            cost=Integer.parseInt(rs2.getString(1));
        }
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
    return cost;
    }
    
}
