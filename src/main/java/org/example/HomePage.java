package org.example;


import org.example.admin.AdminLogin;
import org.example.tests.UserTest;
import org.example.user.UserController;

import java.util.Scanner;

public class HomePage {
    public void homePag() {
        System.out.println("-----------------------------------------");
        System.out.println("|                                        |");
        System.out.println("|           Welcome to our page!         |");
        System.out.println("|                                        |");
        System.out.println("-----------------------------------------");


        System.out.println("            Welcome dear Reader!");
        System.out.println();
        System.out.println("-> Do You really love Books??? ");
        System.out.println();
        System.out.println("   Come with us to the magical world of reading!!!  ");

        //choose between user - admin

        Scanner sc= new Scanner(System.in);
        System.out.println();
        int choice;
        do{
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("Enter your choice: ");
            choice= sc.nextInt();

            switch (choice){
                case 1: AdminLogin adminCRUD= new AdminLogin();
                    adminCRUD.loginAdmin();
                    break;
                case 2:
                    UserTest userTest = new UserTest();
                    userTest.userTest();
                    break;
                default:
                    System.out.println("Error!!! Try again!");
                    break;
            }

        }
        while (choice != 0);

    }
}
