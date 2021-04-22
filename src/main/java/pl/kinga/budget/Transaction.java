package pl.kinga.budget;

import java.sql.Date;
import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private Type type;
    private String description;
    private double amount;
    private Date date;

    public Transaction(Integer id, Type type, String description, double amount, Date date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(Type type, String description, double amount, Date date) {
        this(null, type, description, amount, date);
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
