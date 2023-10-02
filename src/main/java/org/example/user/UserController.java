package org.example.user;


import org.example.HomePage;
import org.example.repositories.BookDao;
import org.example.tests.BookTest;
import org.example.tests.OrderTest;

import java.util.Scanner;

public class UserController {
    public void userOrderCRUD(){
        System.out.println();

        Scanner sc= new Scanner((System.in));
        OrderTest orderTest= new OrderTest();
        BookTest bookTest= new BookTest();


        do{
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. View all books\n" +
                    "2. View all books filtered by genre\n" +
                    "3. Buy a book\n"+
                    "4. Show your orders by order number\n"+
                    "5. Go back to the Home Page");

            System.out.println("Enter your choice: ");

            int choice= sc.nextInt();
            switch (choice){
                case 1: bookTest.getListOfBooks();
                    break;
                case 2:
                    System.out.println("Choose a number: ");
                    System.out.println(" 1.Adventure\n 2.Mystery\n 3.Historical\n 4.Poetry\n 5.Fairytale.");
                    bookTest.findBookByType();
                    break;
                case 3: orderTest.saveOrderForUser();
                    break;
                case 4: orderTest.findOrder();
                    break;
                case 5: HomePage hp= new HomePage();
                    hp.homePag();
                    break;
                default:
                    System.out.println("Enter a valid choice!!!");
                    break;
            }
        }
        while (true);
    }
}

