package com.splitwise.splitwise.model;

import com.splitwise.splitwise.User;

import lombok.Data;

@Data
public abstract class Split {
	private User user;
	protected double amount;

	public Split(User user) {
		this.user = user;
	}
}
