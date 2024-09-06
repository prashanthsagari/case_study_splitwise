package com.splitwise.splitwise.model;

import java.util.List;

import com.splitwise.splitwise.User;

public class PercentExpense extends Expense {

	public PercentExpense(double amount, User paidBy, List<Split> splits) {
		super(amount, paidBy, splits);
	}

	@Override
    public boolean validate() {
        for(Split split: getSplits()){
            if( !(split instanceof PercentSplit))
                return false;
        }

        double totalPercent=0;
        double sumSplitPercent=0;

        for(Split split: getSplits()){
            PercentSplit percentSplit= (PercentSplit) split;
            sumSplitPercent+= percentSplit.getPercent();
        }

        if(totalPercent != sumSplitPercent)
            return false;

        return true;
    }

}
