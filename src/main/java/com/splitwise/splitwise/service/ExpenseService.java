package com.splitwise.splitwise.service;

import java.util.List;

import com.splitwise.splitwise.User;
import com.splitwise.splitwise.model.EqualExpense;
import com.splitwise.splitwise.model.ExactExpense;
import com.splitwise.splitwise.model.Expense;
import com.splitwise.splitwise.model.ExpenseType;
import com.splitwise.splitwise.model.PercentExpense;
import com.splitwise.splitwise.model.PercentSplit;
import com.splitwise.splitwise.model.Split;

public class ExpenseService {
	public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits) {
		switch (expenseType) {
		case EXACT:
			return new ExactExpense(amount, paidBy, splits);
		case EQUAL:
			int totalSplitSize = splits.size();
			double splitAmount = (double) Math.round(amount * 100 / totalSplitSize) / 100.0;
			for (Split split : splits) {
				split.setAmount(splitAmount);
			}

			splits.get(0).setAmount(splitAmount + amount - splitAmount * totalSplitSize);
			return new EqualExpense(amount, paidBy, splits);
		case PERCENT:
			for (Split split : splits) {
				PercentSplit percentSplit = (PercentSplit) split;
				split.setAmount((amount * percentSplit.getPercent()) / 100.0);
			}
			return new PercentExpense(amount, paidBy, splits);
		}

		return null;
	}
}