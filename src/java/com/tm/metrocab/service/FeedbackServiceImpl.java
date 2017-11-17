/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.metrocab.service;

import com.tm.metrocab.beans.Feedback;
import com.tm.metrocab.dao.FeedbackDAO;
import com.tm.metrocab.dao.FeedbackDAOImpl;

/**
 *
 * @author Raghuram
 */
public class FeedbackServiceImpl implements FeedbackService{
    FeedbackDAO feed=new FeedbackDAOImpl();
    @Override
    public int updateFeedback(Feedback fb) {
        System.out.println("in feedbackserviceimpl()");
    return feed.updateFeedback(fb);
    }
    
}
