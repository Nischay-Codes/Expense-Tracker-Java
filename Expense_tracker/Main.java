package oopslogic.Expense_tracker;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        expenseManager manager = new expenseManager();
        manager.loadExpenses();
        LoginSystem loginSystem = new LoginSystem();


        while (true){
            System.out.println("Choose one option:");
            System.out.println("1.Add expense");
            System.out.println("2.Show All Expenses");
            System.out.println("3.Update Expenses");
            System.out.println("4.Delete Expense");
            System.out.println("5.Filter By Category");
            System.out.println("6.Exit");
            int input = sc.nextInt();
            switch (input) {

               case 1:
                   System.out.println("Enter Id:");
                   int id = sc.nextInt();
                   sc.nextLine();
                   System.out.println("Enter title:");
                   String title = sc.nextLine();
                   System.out.println("Enter Amount:");
                   int amount = sc.nextInt();
                   sc.nextLine();
                   System.out.println("Enter category:");
                   String category = sc.nextLine();
                   System.out.println("Enter Date (yyyy-mm-dd):");
                   LocalDate date = LocalDate.parse(sc.nextLine());
                   System.out.println("Enter Note:");
                   String note = sc.nextLine();
                   manager.addExpense(id, title, amount, category, date, note);
                    break;

               case 2:
                   loginSystem.login();
                    manager.showAllExpenses();
                    break;
               case 3:
                   loginSystem.login();
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();
                    manager.updateExpense(updateId,newTitle,newAmount,newCategory);
                    break;
               case 4:
                   loginSystem.login();
                    System.out.println("Enter the element you want to delete:");
                    int delete = sc.nextInt();
                    manager.deleteExpense(delete);
                    break;
               case 5:
                   loginSystem.login();
                    System.out.println("Enter the category to filter:");
                    String cataegory = sc.next();
                    manager.filterByCategory(cataegory);
                    break;
               case 6:
                   System.out.println("Exiting... thank you!");
                   sc.close();
                   return;
                default:
                    System.out.println("Invalid choice please try again!");
            }

        }
    }
}
