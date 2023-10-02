package org.example.tests;

import org.example.entities.User;
import org.example.entities.UserProfile;
import org.example.repositories.UserProfileDao;
import org.example.user.UserController;

import java.util.Scanner;

public class UserProfileLoginTest {
    public void loginProfileUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your email: ");
        String email = sc.nextLine();
        System.out.println("Insert your password: ");
        String password = sc.nextLine();
        User user= new User();

        UserProfile userProfile = new UserProfile();
        UserProfileDao userProfileDao= new UserProfileDao();
        userProfileDao.getUserLoginProfile(new UserProfile(email,password));

//            if (email.equals(userProfile.getEmail()) && password.equals(userProfile.getPassword())) {
//                System.out.println("Login successfully!");
//            }
//                System.out.println("Incorrect authentication!!!");


        System.out.println();
        System.out.println("Welcome dear reader! ");

        //user CRUD orders
        UserController userController = new UserController();
        userController.userOrderCRUD();
    }
}
