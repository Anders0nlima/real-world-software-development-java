package org.example.chapter_03;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double sumarize(double accumulator, BankTransaction bankTransaction);
}
