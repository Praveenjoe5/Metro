/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import com.tm.metrocab.dao.PaymentCabDAO;
import com.tm.metrocab.dao.PaymentCabDAOImpl;
import java.util.List;

/**
 *
 * @author techm
 */
public class PaymentCabServiceImpl implements PaymentCabService {

    public List makePayment(RequestCab requestCab ,BankPayment bankpay ) {
         PaymentCabDAO paymentDAO=new PaymentCabDAOImpl();
        System.out.println("makepayment() from PaymentCabServiceImpl ");
        return paymentDAO.makePayment(requestCab, bankpay);
                }

   
}
