package org.example.chapter_02_overview;

import org.example.chapter_02.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    org.example.chapter_02.BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
