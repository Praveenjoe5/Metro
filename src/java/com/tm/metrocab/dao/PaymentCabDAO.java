/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.BankPayment;
import com.tm.metrocab.beans.RequestCab;
import java.util.List;

/**
 *
 * @author techm
 */
public interface PaymentCabDAO {
     public List makePayment(RequestCab req,BankPayment bank); 
}
