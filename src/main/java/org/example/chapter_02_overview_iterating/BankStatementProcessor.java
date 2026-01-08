package org.example.chapter_02_overview_iterating;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category){
        double total = 0;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateMaxInMonth(final Month month){
        double max = Double.NEGATIVE_INFINITY;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                max = Math.max(max, bankTransaction.getAmount());
            }
        }
        return max;
    }

    public double calculateMinInMonth(final Month month){
        double min = Double.POSITIVE_INFINITY;
        for(final BankTransaction bankTransaction : bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                min = Math.min(min, bankTransaction.getAmount());
            }
        }
        return min;
    }

}
