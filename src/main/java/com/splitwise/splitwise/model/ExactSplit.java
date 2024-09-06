package com.splitwise.splitwise.model;

import com.splitwise.splitwise.User;

public class ExactSplit extends Split {
	
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount= amount;
    }
}