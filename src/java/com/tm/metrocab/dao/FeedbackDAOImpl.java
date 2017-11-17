/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.Feedback;
import com.tm.metrocab.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Raghuram
 */

public class FeedbackDAOImpl implements FeedbackDAO{
Connection con=JDBCUtil.getConnection();
int result;
String r="";
String city,carid;
//to insert the feedback given by the valid customer
    @Override
    public int updateFeedback(Feedback fb) {
    try {
        System.out.println(fb.getBookingId());
        PreparedStatement ps1=con.prepareStatement("select booking_id,city from metro where booking_id=?");
        ps1.setString(1, fb.getBookingId());
        ResultSet rs=ps1.executeQuery();
        if(rs.next())
        {
         r=Integer.toString(rs.getInt(1));
         city=rs.getString(2);
        }
        System.out.println(r+" "+city);
        if(r.equals(fb.getBookingId()))
        {
            String qq="select car_id from metro_"+city+"1 where booking_id=?";
                        PreparedStatement ps2=con.prepareStatement(qq);
                        ps2.setInt(1, Integer.parseInt(fb.getBookingId()));
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next())
            {
                carid=rs2.getString(1);
            }
        PreparedStatement ps=con.prepareStatement("insert into feedback values(?,?,?,?,?)");
        ps.setString(1,fb.getBookingId());
        ps.setString(2, fb.getDate());
        ps.setString(3, fb.getFeed());
        ps.setString(4, city);
        ps.setString(5, carid);
        result=ps.executeUpdate();
    }
        else
        {
            result=2;
        }
    }catch (SQLException ex) {
        System.out.println(ex);
    }finally {
        JDBCUtil.closeConnection(con);
    }
    return result;
    }
    
    
    
}
