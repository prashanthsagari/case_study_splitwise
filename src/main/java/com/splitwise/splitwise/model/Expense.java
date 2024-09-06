package com.splitwise.splitwise.model;

import java.util.List;

import com.splitwise.splitwise.User;

import lombok.Data;

@Data
public abstract class Expense {

	private String id;
	private double amount;
	private User paidBy;
	private List<Split> splits;

	public Expense(double amount, User paidBy, List<Split> splits) {
		this.amount = amount;
		this.paidBy = paidBy;
		this.splits = splits;
	}
	
	public abstract boolean validate();

}
