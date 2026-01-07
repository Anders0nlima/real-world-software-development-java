package org.example.chapter_02_overview;

import org.example.chapter_02.BankStatementParser;
import org.example.chapter_02.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private org.example.chapter_02.BankTransaction parseFromCSV(final String line){
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATA_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new org.example.chapter_02.BankTransaction(date, amount, description);
    }

    public List<org.example.chapter_02.BankTransaction> parceLinesFromCSV(final List<String> lines){
        final List<org.example.chapter_02.BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line : lines){
            bankTransactions.add(parseFromCSV(line));
        }
        return bankTransactions;
    }

    @Override
    public org.example.chapter_02.BankTransaction parseFrom(String line) {
        return parseFromCSV(line);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return parceLinesFromCSV(lines);
    }
}
