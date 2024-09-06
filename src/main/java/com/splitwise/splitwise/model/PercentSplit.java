package com.splitwise.splitwise.model;

import com.splitwise.splitwise.User;

import lombok.Data;

@Data
public class PercentSplit extends Split {
	private double percent;

	public PercentSplit(User user, double percent) {
		super(user);
		this.percent = percent;
	}
}
