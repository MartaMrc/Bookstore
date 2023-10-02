package org.example.admin;


import java.util.Scanner;
import org.example.tests.AdminTest;

public class AdminLogin {

    public void loginAdmin(){

        Scanner sc= new Scanner(System.in);
        final String adminUsername= "admin";
        final String adminPassword= "admin";

        System.out.println("Insert the username: ");
        String username= sc.nextLine();
        System.out.println("Insert the password: ");
        String password= sc.nextLine();

        if(adminUsername.equals(username)) {
            if (adminPassword.equals(password)) {
                System.out.println();
                System.out.println("Authentication successful!");
                System.out.println("-----------");

                System.out.println("Welcome ~" + adminUsername + "~");
                AdminTest test= new AdminTest();
                test.adminCRUD();

            } else {
                System.out.println("-----------");
                System.out.println("Invalid Password! Try again!!!");

            }
        }else {
            System.out.println("-----------");
            System.out.println("Invalid Username! Try again!!!");
        }
    }
}
