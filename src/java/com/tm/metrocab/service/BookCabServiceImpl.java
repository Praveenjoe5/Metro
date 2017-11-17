/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.BookCabDAO;
import com.tm.metrocab.dao.BookCabDAOImpl;

/**
 *
 * @author techm
 */
public class BookCabServiceImpl implements BookCabService {
    BookCabDAO checkDAO=new BookCabDAOImpl();
    public int checkRequest(RequestCab req) {
    System.out.println("checkRequest() from bookcabServiceImpl ");
        return checkDAO.checkRequest(req);   
    }
    
}
