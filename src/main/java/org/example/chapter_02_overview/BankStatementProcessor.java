package org.example.chapter_02_overview;

import org.example.chapter_02.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<org.example.chapter_02.BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<org.example.chapter_02.BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for(final org.example.chapter_02.BankTransaction bankTransaction : bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for(final org.example.chapter_02.BankTransaction bankTransaction : bankTransactions){
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
}
