package org.example.chapter_02_overview;

import org.example.chapter_02.BankStatementCSVParser;
import org.example.chapter_02.BankStatementParser;
import org.example.chapter_02.BankStatementProcessor;
import org.example.chapter_02.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final org.example.chapter_02.BankStatementCSVParser bankStatementParser = new org.example.chapter_02.BankStatementCSVParser();

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final org.example.chapter_02.BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parceLinesFromCSV(lines);
        final org.example.chapter_02.BankStatementProcessor bankStatementProcessor = new org.example.chapter_02.BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions is january is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions is fabruary is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
