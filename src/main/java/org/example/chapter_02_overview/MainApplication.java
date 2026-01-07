package org.example.chapter_02_overview;

import org.example.chapter_02.BankStatementAnalyzer;
import org.example.chapter_02.BankStatementCSVParser;
import org.example.chapter_02.BankStatementParser;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final org.example.chapter_02.BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
    }
}
