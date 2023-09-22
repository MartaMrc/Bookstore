package hibernate.project.user;

import hibernate.project.entities.User;
import hibernate.project.repositories.UserDao;

import java.util.Scanner;

public class UserRegistration {
    public void usRegistration(){

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = sc.next();

        System.out.println("Enter your last name:");
        String lastName = sc.next();

        System.out.println("Enter Email:");
        String email = sc.next();

        System.out.println("Enter New Password:");
        String password = sc.next();

        System.out.println("Enter Phone Number:");
        String phoneNr = sc.next();
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNr);

        UserDao dao= new UserDao();
        dao.createAccountUser(user);

        System.out.println("Your account has been registered to the system!");
        System.out.println("----------");
        System.out.println("Sign in : ");

        // login after registration
        UserLogin userLogin= new UserLogin();
        userLogin.usLog();

    }
}
