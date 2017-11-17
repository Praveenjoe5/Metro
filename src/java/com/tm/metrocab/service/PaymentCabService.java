/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import java.util.List;

/**
 *
 * @author techm
 */
public interface PaymentCabService {
     public List makePayment(RequestCab requestCab,BankPayment bankpay);
}
