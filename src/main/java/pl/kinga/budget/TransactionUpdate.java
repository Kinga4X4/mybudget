package pl.kinga.budget;

import java.sql.Date;

import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji, którą chcesz zaktualizować");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj typ transakcji. Dostępne typy:");
        Type[] type = Type.values();
        for (Type type1 : type) {
            type1.name();
        }
        String type1 = scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();
        System.out.println("Podaj kwotę transakcji");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj datę transakcji");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.update(transaction);
    }
}

