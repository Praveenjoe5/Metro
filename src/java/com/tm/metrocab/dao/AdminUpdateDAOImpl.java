/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.AdminUpdate;
import com.tm.metrocab.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AdminUpdateDAOImpl implements AdminUpdateDAO{
String status;
String bookid;
int flag;
Connection con=JDBCUtil.getConnection();
// to update in table by admin such as delete,update status
    public int adminUpdate(AdminUpdate admin) {
    status=admin.getStatus();
    bookid=admin.getBookingId();
       
        System.out.println(bookid);
    try
    {     
    if(status!=null)
     {
         PreparedStatement ps1=con.prepareStatement("update metro set status=? where booking_id=?");
         ps1.setString(1,status);
         ps1.setString(2, bookid);
         flag=ps1.executeUpdate();
     }
    else if(status==null)
    {
        PreparedStatement ps=con.prepareStatement("delete from metro where booking_id=?");
        ps.setString(1, bookid);
        flag=ps.executeUpdate();
    }
        
    }
    catch(SQLException se)
    {
        System.out.println(se);
    }
    return flag;
    }
}
