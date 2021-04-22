package pl.kinga.budget;

import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private Type type;
    private String description;
    private int amount;
    private LocalDate date;

    public Transaction(Integer id, Type type, String description, int amount, LocalDate date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transakcja:" +
                "id: " + id +
                ", typ " + type + " " +
                ", opis: " + description + " " +
                ", kwota: " + amount +
                ", data:" + date +
                '}';
    }
}
