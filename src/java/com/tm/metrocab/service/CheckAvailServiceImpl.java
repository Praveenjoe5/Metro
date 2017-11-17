/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.CheckAvailDAO;
import com.tm.metrocab.dao.CheckAvailDAOImpl;
/**
 *
 * @author TechM
 */
public class CheckAvailServiceImpl implements CheckAvailService{
CheckAvailDAO checkDAO=new CheckAvailDAOImpl();
    @Override
    public String checkAvail(RequestCab req) {
     System.out.println("check avail in service method ");
     return checkDAO.checkAvail(req);
    }
    
}
