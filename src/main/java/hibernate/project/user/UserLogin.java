package hibernate.project.user;

import hibernate.project.entities.UserProfile;
import hibernate.project.repositories.UserProfileDao;
import jdbc.project.repositories.UserDao;

import java.util.Scanner;

public class UserLogin {

    public void saveProfileUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your email: ");
        String email = sc.nextLine();
        System.out.println("Insert your password: ");
        String password = sc.nextLine();

        UserProfile userProfile = new UserProfile();
        userProfile.setEmail(email);
        userProfile.setPassword(password);
        UserProfileDao userProfileDao = new UserProfileDao();

        userProfileDao.saveUserProfile(userProfile);
    }




    public void usLog(){
        // login using hibernate conn  !!! some errors
//        UserProfileDao userProfileDao= new UserProfileDao();
//        UserProfile userProfile= new UserProfile();
//        userProfileDao.logUs();


        //login using jdbc conn
        UserDao userDao= new UserDao();
        userDao.logUs();







    }


}
