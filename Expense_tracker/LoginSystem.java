package oopslogic.Expense_tracker;

import java.util.Scanner;

public class LoginSystem {
    public void login(){
        final String userName = "user";
        final String password = "123";
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the Username:");
        String inputUsername = sc.next();
        System.out.println("please enter the password:");
        String inputpassword = sc.next();
        System.out.println("Validating...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (userName.equalsIgnoreCase(inputUsername)&&password.equalsIgnoreCase(inputpassword)){
            System.out.println("Login Successful");
        }else System.out.println("Incorrect credentials");
    }
}
