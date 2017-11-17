/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.CancelBookDAO;
import com.tm.metrocab.dao.CancelBookDAOImpl;

/**
 *
 * @author Raghuram
 */
public class CancelCabServiceImpl implements CancelCabService {
CancelBookDAO cancelDAO=new CancelBookDAOImpl();
    @Override
    public int cancelRequest(RequestCab req) {
        System.out.println("insertUser() from requestcabServiceImpl ");
        return cancelDAO.cancelRequest(req);
    }

}
