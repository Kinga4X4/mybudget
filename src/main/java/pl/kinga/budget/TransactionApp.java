package pl.kinga.budget;

import java.sql.*;
import java.util.Scanner;

public class TransactionApp {
    private Connection connection;
    Scanner scanner = new Scanner(System.in);

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

        while (true) {
            System.out.println("Wybierz jedną z opcji. Dostępne opcje:");
            System.out.println("1. Dodawanie transakcji:");
            System.out.println("2. Modyfikacja transakcji:");
            System.out.println("3. Usuwanie transakcji:");
            System.out.println("4. Wyświetlanie wszystkich przychodów");
            System.out.println("5. Wyświetlanie wszystkich wydatków");
            System.out.println("0. Wyjście/Koniec");
            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    System.out.println("dodawanie trancakcji jakis");
                    break;
                case "2":
                    System.out.println("modyfikacja trancakcji jakis");
                    break;

                case "3":
                    System.out.println("usuwanie trancakcji jakis");
                    break;
                case "4":
                    allIncome();
                    break;
                case "5":
                    allExpenses();
                    break;
                case "0":
                    close();
                    break;
                default:
                    System.out.println("Nieznana opcja!");
            }
        }
    }

    private void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Błąd podczas zamykania połączenia" + throwables.getMessage());
        }
    }

    private void allIncome() {
        try {
            String sql = "SELECT * FROM transaction where type='przychód'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                System.out.println(type + ": " + description + " " + amount + " EUR");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void allExpenses() {

        try {
            String sql = "SELECT * FROM transaction where type='wydatek'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                int amount = resultSet.getInt("amount");
                System.out.println(type + ": " + description + " " + amount + " EUR");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void addTransaction() {

        System.out.println("Podaj typ transakcji: wydatek lub przychod?");
        String type1 = scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String description1 = scanner.nextLine();
        System.out.println("Podaj kwotę transakcji");
        int amount1 = scanner.nextInt();
        System.out.println("Podaj datę transakcji");
        String date1 = scanner.nextLine();

        try {
            Statement preparedStatement = connection.prepareStatement("UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? where id = ?");
            ((PreparedStatement) preparedStatement).setString(1, type1);
            ((PreparedStatement) preparedStatement).setString(2, description1);
            ((PreparedStatement) preparedStatement).setInt(3, amount1);
            ((PreparedStatement) preparedStatement).setString(4, date1);
            int rowsChanged = preparedStatement.executeUpdate();
            System.out.println("zaktualizowane rekordy" + " " + rowsChanged);

//            while (resultSet.next()) {
//                String type = resultSet.getString("type");
//                String description = resultSet.getString("description");
//                int amount = resultSet.getInt("amount");
//                System.out.println(type + ": " + description + " " + amount + " EUR");
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
