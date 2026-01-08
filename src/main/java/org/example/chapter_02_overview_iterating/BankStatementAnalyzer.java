package org.example.chapter_02_overview_iterating;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES, "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions is january is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions is Fabruary is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("the maximum value in January is " + bankStatementProcessor.calculateMaxInMonth(Month.JANUARY));
        System.out.println("the minimum value in January is " + bankStatementProcessor.calculateMinInMonth(Month.JANUARY));
        System.out.println("the maximum value in Fabruary is " + bankStatementProcessor.calculateMaxInMonth(Month.FEBRUARY));
        System.out.println("the minimum value in Fabruary is " + bankStatementProcessor.calculateMinInMonth(Month.FEBRUARY));
    }
}
