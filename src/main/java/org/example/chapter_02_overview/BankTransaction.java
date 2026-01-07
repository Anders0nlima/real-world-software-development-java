package org.example.chapter_02_overview;

import java.time.LocalDate;
import java.util.Objects;

//parte_1
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String descriptions){
        this.date = date;
        this.amount = amount;
        this.description = descriptions;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return "BankTransaction{" +
                "date = " + date +
                ", amount = " + amount +
                ", description = " + description +
                "}";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(date, amount, description);
    }
}
