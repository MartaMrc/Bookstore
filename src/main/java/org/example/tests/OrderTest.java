package org.example.tests;

import org.example.entities.Book;
import org.example.entities.Orders;
import org.example.entities.User;
import org.example.entities.UserProfile;
import org.example.repositories.BookDao;
import org.example.repositories.OrdersDao;
import org.example.repositories.UserDao;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderTest {
    OrdersDao ordersDao = new OrdersDao();
    UserDao userDao = new UserDao();
    Scanner sc= new Scanner(System.in);
    BookDao bookDao= new BookDao();

    public void saveOrderForUser(){
        System.out.println("Insert the first name: ");
        String fName= sc.nextLine();
        System.out.println("Insert the last name: ");
        String lName= sc.nextLine();
        System.out.println("Insert the email: ");
        String email= sc.nextLine();
        System.out.println("Insert the phone number: ");
        String phoneNo= sc.nextLine();
        System.out.println("Insert the address: ");
        String address= sc.nextLine();

        System.out.println("Insert the title of the book and the author: ");
        String content= sc.nextLine();

        User user = new User(fName,lName,email,phoneNo, address);
        userDao.saveUser(user);



        Orders orders= new Orders(content);
        orders.setUser(user);

        ordersDao.saveOrder(orders);
    }

    public void findAllBooks() {
        List <Book> findBookByType = bookDao.getBookList();
        System.out.println();
        System.out.println("List of books:  ");
        for (Book b : findBookByType) {
            System.out.println( b.getTitleBook()+"->  "+ b.getFirstNameAuthor() + " "  + b.getLastNameAuthor()
                    + " costs " + b.getPriceBook() + " -> " + b.getBookType());
        }
    }

    public void showAllBooksByType() {
        List <Book> bookList = bookDao.getBooks();
        System.out.println();
//        System.out.println("Enter the id to be able to filter the list of books: ");
//        int id= sc.nextInt();
        System.out.println("List of books:  ");

        bookList.forEach(b -> System.out.println( b.getTitleBook()+"->  "+ b.getFirstNameAuthor() + " "  + b.getLastNameAuthor()
                + " costs " + b.getPriceBook() + " -> " + b.getBookType()));
    }

    //find order by id
    public void findOrder() {
        System.out.println("Insert the order number to find your order: ");
        int id = sc.nextInt();
        ordersDao.findOrderById(id);

    }

    //delete order by id
    public void deleteOrderById(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Insert an id to delete an order: ");
        int id= scanner.nextInt();
        ordersDao.deleteOrderById(id);
        System.out.println("Order is deleted!!!");}


}
