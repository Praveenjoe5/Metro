/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.StatusCheckDAO;
import com.tm.metrocab.dao.StatusCheckDAOImpl;
import java.util.List;

/**
 *
 * @author techm
 */
public class StatusCheckServiceImpl implements StatusCheckService{
StatusCheckDAO statusDAO=new StatusCheckDAOImpl();
    public int checkStatus(RequestCab req) {
         System.out.println("checkStatus() from statuscheckServiceImpl ");
        return statusDAO.checkStatus(req);
    }

    public int checkCost(RequestCab req) {
         System.out.println("checkCost() from statuscheckServiceImpl ");
         return statusDAO.checkCost(req);
    }
public List getCarDetails(RequestCab req)
{
    System.out.println("in getcardetails from statuscheckserviceimpl");
    return statusDAO.getCarDetails(req);
}
    
    
}
