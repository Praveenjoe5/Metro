/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.RequestCab;
import java.util.List;

/**
 *
 * @author techm
 */
public interface StatusCheckService {
     public int checkStatus(RequestCab req);
     public int checkCost(RequestCab req);
     public List getCarDetails(RequestCab req);
}
