package org.example.tests;

import org.example.repositories.BookDao;

import org.example.entities.Book;
import org.example.util.BookType;

import java.util.List;
import java.util.Scanner;

public class BookTest {
    Scanner sc= new Scanner(System.in);

    Book books= new Book();
    BookDao bookDao= new BookDao();

    public void bookSaveInDb(){

        System.out.println("Enter the title's book: ");
        String title = sc.next();

        System.out.println("Enter the author's first name: ");
        String authorFirstN = sc.next();

        System.out.println("Enter the author's last name: ");
        String authorLastN = sc.next();

        System.out.println("Enter the price of the book: ");
        double price = sc.nextDouble();

        System.out.println("Enter the type of book");
        int id= sc.nextInt();


        books.setTitleBook(title);
        books.setFirstNameAuthor(authorFirstN);
        books.setLastNameAuthor(authorLastN);
        books.setPriceBook(price);
        books.setBookType(BookType.bookType(id));
        bookDao.saveBook(books);

        System.out.println("Your book has been registered to the system!!!");
        System.out.println("----------------------------------------------");
    }


    //      list all books in DB
    public void getListOfBooks() {
        List <Book> bookList = bookDao.getBookList();
        System.out.println();
        System.out.println("List of books:  ");
        for (Book b : bookList) {
            System.out.println( b.getTitleBook()+"->  "+ b.getFirstNameAuthor() + " "  + b.getLastNameAuthor()
                     + " costs " + b.getPriceBook() + " -> " + b.getBookType());
        }
    }
    public void findBookByType() {
        List <Book> findBookByType = bookDao.getBooks();
        System.out.println();
        System.out.println("List of books:  ");
        for (Book b : findBookByType) {
            System.out.println( b.getTitleBook()+"->  "+ b.getFirstNameAuthor() + " "  + b.getLastNameAuthor()
                    + " costs " + b.getPriceBook() + " -> " + b.getBookType());
        }
    }


    // update book in DB
    public void updateBookByPrice(){
        bookDao.updatePriceByISBN(books);}


    //delete book
    public void deleteBookByISBN(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Insert an ISBN to delete a book: ");
        int isbn= scanner.nextInt();
        bookDao.deleteBook(isbn);
        System.out.println("Book is deleted!!!");}

    //find book by id
    public void getBookByISBN() {
        System.out.println("Insert an ISBN to find a book");
        int isbn = sc.nextInt();
        bookDao.findBookByISBN(isbn);
    }
}
