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

/**
 *
 * @author techm
 */
public class BookCabDAOImpl implements BookCabDAO {
Connection connection=JDBCUtil.getConnection();
int result=0;
String city;
//to display customer to check availablity of the requested cab
    public int checkRequest(RequestCab req) {
        try{
            PreparedStatement ps1=connection.prepareStatement("select city from metro where booking_id=?");
            ps1.setString(1, req.getBookingId());
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next())
            {
               city=rs1.getString(1); 
            }
            String qq="select status from metro_"+city+"1 where booking_id=?";
            PreparedStatement ps=connection.prepareStatement(qq);
           ps.setString(1, req.getBookingId());
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                if(rs.getString(1).equals("available"))
                {
                    result=1;
                }
        }
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
        return result;
    }
    
}
