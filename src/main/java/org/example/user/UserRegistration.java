package org.example.user;

import org.example.entities.User;
import org.example.entities.UserProfile;
import org.example.repositories.UserDao;
import org.example.repositories.UserProfileDao;
import org.example.tests.UserProfileLoginTest;

import java.util.Scanner;

public class UserRegistration {
    UserDao userDao= new UserDao();
    UserProfileDao userProfileDao= new UserProfileDao();

    public void usRegistration(){

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = sc.next();

        System.out.println("Enter your last name:");
        String lastName = sc.next();

        System.out.println("Enter Email:");
        String email = sc.next();

        System.out.println("Enter Phone Number:");
        String phoneNr = sc.next();
        System.out.println("Enter your address:");
        String address = sc.next();
        System.out.println("Enter your new password:");
        String password = sc.next();


        User user = new User(firstName,lastName,email,phoneNr, address);
        userDao.saveUser(user);

        UserProfile userProfile= new UserProfile(email,password);
        userProfile.setPassword(password);
        userProfile.setEmail(email);
        userProfile.setUser(user);

        userProfileDao.saveUserLoginProfile(userProfile);


        System.out.println("Your account has been registered to the system!");
        System.out.println("----------");
        System.out.println("Sign in : ");

        // login after registration
//        UserLogin userLogin= new UserLogin();
//        userLogin.saveProfileUser();
        UserProfileLoginTest userProfileLoginTest = new UserProfileLoginTest();
        userProfileLoginTest.loginProfileUser();

    }
}
