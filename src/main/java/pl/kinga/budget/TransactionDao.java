package pl.kinga.budget;

import java.sql.*;
public class TransactionDao {
    private Connection connection;

    void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("brak sterownika");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/home_budget?serverTimezone=UTC";
        connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException throwables) {
            System.out.println("Błąd podczas nawiazania połączenia" + throwables.getMessage());
            return;
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Błąd podczas zamykania połączenia" + throwables.getMessage());
        }
    }

    public void allIncome() {
        try {
            String sql = "SELECT * FROM transaction where type='przychód'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                double amount = resultSet.getInt("amount");
                System.out.println(type + ": " + description + " " + amount + " EUR");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void allExpenses() {

        try {
            String sql = "SELECT * FROM transaction where type='wydatek'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                double amount = resultSet.getInt("amount");
                System.out.println(type + ": " + description + " " + amount + " EUR");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Transaction transaction) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? where id = ?");
            preparedStatement.setString(1, transaction.getType() );
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            int rowsChanged = preparedStatement.executeUpdate();
            System.out.println("zaktualizowane rekordy" + " " + rowsChanged);

        } catch (SQLException throwables) {
            System.out.println("Niepowodzenie podczas zapisu do bazy danych" + throwables.getMessage());
        }
    }

    public void addTransaction(Transaction transaction) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transaction (type, description, amount, date) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
    }

    public void deleteById(String id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM transaction WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + throwables.getMessage());
        }
    }
}



