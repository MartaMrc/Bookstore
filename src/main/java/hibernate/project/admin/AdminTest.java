package hibernate.project.admin;

import hibernate.project.HomePag;
import hibernate.project.book.BookTest;

import java.util.Scanner;

public class AdminTest {
    public void adminCRUD(){
        System.out.println();
//        System.out.println("What do you want to find?");

        Scanner sc= new Scanner((System.in));
        BookTest bookTest= new BookTest();


        do{
            System.out.println("What do you want to find?");
            System.out.println("1. Add book in DB\n" +
                    "2. Show all books\n" +
                    "3. Show the books by id\n"+
                    "4. Update the price of a book\n"+
                    "5. Delete a book from DB by ISBN\n" +
                    "6. Go back to the Home Page");

            System.out.println("Enter your choice: ");

            int choice= sc.nextInt();
            switch (choice){
                case 1: bookTest.bookSaveInDb();
                    break;
                case 2: bookTest.getListOfBooks();
                    break;
                case 3: bookTest.getBookByISBN();
                    break;

                case 4: bookTest.updateBookByPrice();
                    break;
                case 5: bookTest.deleteBookByISBN();
                    break;
//                case 7: bookTest.deleteBookByTitle();
//                    break;
                case 6: HomePag hp= new HomePag();
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
