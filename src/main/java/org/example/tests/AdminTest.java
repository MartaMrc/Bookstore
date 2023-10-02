package org.example.tests;

import org.example.HomePage;
import org.example.util.BookType;

import java.util.Scanner;

public class AdminTest {
    public void adminCRUD(){
        System.out.println();
//        System.out.println("What do you want to find?");

        Scanner sc= new Scanner((System.in));
        BookTest bookTest= new BookTest();


        do{
            System.out.println();
            System.out.println("What do you want to find?");
            System.out.println("1. Add book in DB\n" +
                    "2. Show all books\n" +
                    "3. Show the books by ISBN\n"+
                    "4. Filter the books by genre\n"+
                    "5. Update the price of a book\n"+
                    "6. Delete a book from DB by ISBN\n" +
                    "7. Go back to the Home Page");

            System.out.println("Enter your choice: ");

            int choice= sc.nextInt();
            switch (choice){
                case 1: bookTest.bookSaveInDb();
                    break;
                case 2: bookTest.getListOfBooks();
                    break;
                case 3: bookTest.getBookByISBN();
                    break;
                case 4: bookTest.findBookByType();
                    break;
                case 5: bookTest.updateBookByPrice();
                    break;
                case 6: bookTest.deleteBookByISBN();
                    break;
                case 7: HomePage hp= new HomePage();
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

