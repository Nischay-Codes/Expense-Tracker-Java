package oopslogic.Expense_tracker;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    final String file = "ExpenseTracker.txt";


    public List<expense> loadFromFile() {
        List<expense> expenses = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                double amount = Double.parseDouble(data[2]);
                String category = data[3];
                LocalDate date = LocalDate.parse(data[4]);
                String note = data[5];

                expense ex = new expense(id,title,amount,category,date,note);
                expenses.add(ex);

            }

            reader.close();
            System.out.println(" Expenses loaded successfully!");

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }

        return expenses;
    }



    public void saveExpensesToFile(List<expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (expense e : expenses) {
                String line = e.getId() + "," + e.getTitle() + "," + e.getAmount() + "," +
                        e.getCatagory() + "," + e.getDate() + "," + e.getNote();
                writer.write(line);
                writer.newLine();
            }
            System.out.println(" Expenses saved to file.");
        } catch (IOException e) {
            System.out.println(" Error saving expenses: " + e.getMessage());
        }
    }

}
