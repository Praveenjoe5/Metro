/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.dao;

import com.tm.metrocab.beans.RequestCab;

/**
 *
 * @author Raghuram
 */
public interface CancelBookDAO {
     public int cancelRequest(RequestCab req); 
}
