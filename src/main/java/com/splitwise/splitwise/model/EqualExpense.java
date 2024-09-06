package com.splitwise.splitwise.model;

import java.util.List;

import com.splitwise.splitwise.User;

public class EqualExpense extends Expense {

	public EqualExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	@Override
	public boolean validate() {
		for (Split split : getSplits()) {
			if (!(split instanceof EqualSplit))
				return false;
		}

		return true;
	}

}
