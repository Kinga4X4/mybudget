package pl.kinga.budget;

public class Transaction {
    private Integer id;
    private String type;
    private String description;
    private int amount;
    private String date;

    public Transaction(String type, String description, int amount, String date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(Integer id, String type, String description, int amount, String date) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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






}
