package org.example;

import org.example.user.UserLogin;

public class Main {
    public static void main(String[] args) {

        //mapping many to one
//        UserDao userDao= new UserDao();
//        CustomOrderDao customOrderDao= new CustomOrderDao();
//
//        User user=new User("Marta","Marcu","marta.mrc13@gmail.com","Marta13.","0740353745");
//        userDao.saveUser(user);
//        CustomOrder customOrder1= new CustomOrder("2 Books");
//        customOrder1.setUser(user);
//        customOrderDao.saveCustomOrder(customOrder1);

//        BookTest tst= new BookTest();
//        tst.getListOfBooksByAuthor();


//        UserLogin userLogin= new UserLogin();
////        userLogin.saveProfileUser();
//        userLogin.usLog();



        HomePag hp= new HomePag();
        hp.homePag();
    }
}