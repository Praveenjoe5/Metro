/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.util.JDBCUtil;
import com.tm.metrocab.beans.RequestCab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class RequestCabDaoImpl implements RequestCabDAO {
static int cid;

    Connection connection=JDBCUtil.getConnection();
    //generating booking id for new customers
public int count()
{
    Random randomGenerator = new Random();
        for (int idx = 1; idx <= 10; ++idx){
        cid = randomGenerator.nextInt(99999);
}
        return cid;
}
//to insert the requested data into "metro" table
@Override
    public int insertRequest(RequestCab req) {
       
        int result=0;
        
        try{
            
            PreparedStatement ps=connection.prepareStatement("insert into metro values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           ps.setInt(1, count());
            ps.setString(2,req.getCity());
            ps.setString(3,req.getService());
            ps.setString(4,req.getType());
            ps.setString(5,req.getDate());
            ps.setString(6,req.getTime());
            ps.setString(7,req.getPlace());
            ps.setString(8,req.getDestination());            
            ps.setString(9,req.getLandMark());
            ps.setString(10,req.getCustomerName());
            ps.setString(11,req.getCustomerContact());
            ps.setString(12,req.getPersonTravel());
            ps.setString(13, req.getIdCardType());
            ps.setString(14,req.getIdCardNo());
            ps.setString(15,"not paid");
           result =ps.executeUpdate();
           
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;   
    
            }


   
}