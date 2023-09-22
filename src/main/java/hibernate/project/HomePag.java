package hibernate.project;

import hibernate.project.admin.Admin;
import hibernate.project.user.UserTest;

import java.util.Scanner;

public class HomePag {
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

        //choose between user / admin

        Scanner sc= new Scanner(System.in);
        System.out.println();
        int choice;
        do{
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("Enter your choice: ");
            choice= sc.nextInt();

            switch (choice){
                case 1: Admin adminCRUD= new Admin();
                    adminCRUD.loginAdmin();
                    break;
                case 2: UserTest userTest = new UserTest();
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
