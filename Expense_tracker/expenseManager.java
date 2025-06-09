package oopslogic.Expense_tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class expenseManager {
    List<expense> expenseList = new ArrayList<>();
    FileService fileService = new FileService();

    public void addExpense(int id, String title, double amount, String category, LocalDate date, String note){
        expense expense = new expense(id,title,amount,category,date,note);
        expenseList.add(expense);
        fileService.saveExpensesToFile(expenseList);
    }
    public void showAllExpenses() {
        for (expense ex : expenseList) {
            System.out.println("ID: " + ex.getId());
            System.out.println("Title: " + ex.getTitle());
            System.out.println("Amount: ₹" + ex.getAmount());
            System.out.println("Category: " + ex.getCatagory());
            System.out.println("Date: " + ex.getDate());
            System.out.println("Note: " + ex.getNote());
            System.out.println("----------------------------");
        }
    }
    public void updateExpense(int id, String title, double amount, String category){
        boolean found = false;
        for (expense e : expenseList) {
            if (e.getId() == id){
                e.setTitle(title);
                e.setAmount(amount);
                e.setCatagory(category);
                found = true;
                fileService.saveExpensesToFile(expenseList); // Save after update
                break;
            }
        }
        if (!found) System.out.println("Cannot find the expense you were searching for");
    }
    public void updateExpenceAmount(int id,double amount){
        boolean found = false;
        for (expense e : expenseList) {
            if (e.getId() == id){
                e.setAmount(amount);
                found = true;
                break;
            }else System.out.println("Cannot find the expense you were searching for");
        }
    }

    public void deleteExpense(int id) {
        boolean delete = expenseList.removeIf(e -> e.getId() == id);
        if (delete){
            fileService.saveExpensesToFile(expenseList); // Save after delete
            System.out.println("Expense removed successfully");
        } else {
            System.out.println("Expense with ID " + id + " not found");
        }
    }



    public void filterByCategory(String category){
        boolean found = false;
        for (expense e : expenseList) {
            if (e.getCatagory().equalsIgnoreCase(category)){
                System.out.println("Id: "+e.getId()+" Title: "+e.getTitle()+" Amount: "+e.getAmount());
                found = true;
            }
        }
        if (!found) System.out.println("No expenses found in this category");
    }

    public void loadExpenses() {
        List<expense> loaded = fileService.loadFromFile();
        expenseList.addAll(loaded);
    }


}
