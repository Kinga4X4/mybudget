package pl.kinga.budget;

import java.util.Scanner;

import static jdk.internal.net.http.common.Utils.close;

public class TransactionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    TransactionAdd.main(new String[0]);
                    break;
                case "2":
                    TransactionUpdate.main(new String[0]);
                    break;
                case "3":
                    TransactionDelete.main(new String[0]);
                    break;
                case "4":
                    TransactionAllIncome.main(new String[0]);
                    break;
                case "5":
                    TransactionAllExpenses.main(new String[0]);
                    break;
                case "0":
                    close();
                    break;
                default:
                    System.out.println("Nieznana opcja!");
            }
        }
    }

}
