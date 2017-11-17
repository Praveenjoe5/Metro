/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.PaymentCabDAO;
import com.tm.metrocab.dao.PaymentCabDAOImpl;
import com.tm.metrocab.dao.RequestCabDAO;
import com.tm.metrocab.dao.RequestCabDaoImpl;
public class RequestCabServiceImpl implements RequestCabService
{
 RequestCabDAO requestDAO=new RequestCabDaoImpl();
     @Override
    public int insertRequest(RequestCab req) {
        System.out.println("insertUser() from requestcabServiceImpl ");
        return requestDAO.insertRequest(req);
    }

}
