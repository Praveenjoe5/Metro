/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.AdminUpdate;
import com.tm.metrocab.dao.AdminUpdateDAO;
import com.tm.metrocab.dao.AdminUpdateDAOImpl;

/**
 *
 * @author techm
 */
public class AdminUpdateServiceImpl implements AdminUpdateService{
AdminUpdateDAO adminDAO=new AdminUpdateDAOImpl();
    public int adminUpdate(AdminUpdate admin) {
   return adminDAO.adminUpdate(admin); 
    }
    
}
