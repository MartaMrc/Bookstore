package org.example.tests;

import org.example.entities.UserProfile;
import org.example.repositories.UserDao;
import org.example.user.UserRegistration;

import java.util.Scanner;

public class UserTest {
    public void userTest(){
        UserDao dao= new UserDao();
        UserProfile userProfile= new UserProfile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    UserRegistration userRegistration= new UserRegistration();
                    userRegistration.usRegistration();
                    break;

                case 2:
                    UserProfileLoginTest userProfileLoginTest = new UserProfileLoginTest();
                    userProfileLoginTest.loginProfileUser();

                    break;
                default:
                    System.out.println("Error!!! Try again!");
                    break;

            }
            break;

        }
        while (choice != 0);

    }
}

