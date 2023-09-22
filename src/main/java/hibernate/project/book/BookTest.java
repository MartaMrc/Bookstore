package hibernate.project.book;

import hibernate.project.entities.Book;
import hibernate.project.repositories.BookDao;

import java.util.List;
import java.util.Scanner;

public class BookTest {
    Scanner sc= new Scanner(System.in);

    Book book= new Book();
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

        book.setTitleBook(title);
        book.setFirstNameAuthor(authorFirstN);
        book.setLastNameAuthor(authorLastN);
        book.setPriceBook(price);

        bookDao.saveBook(book);
        System.out.println("Your book has been registered to the system!!!");}


    //      list all books in DB
    public void getListOfBooks() {
        List <Book> bookList = bookDao.getBooks();
        System.out.println("List of books:");

        bookList.forEach(b -> System.out.println(b.getFirstNameAuthor() + " " + b.getLastNameAuthor() + "-> "
                + b.getTitleBook() + " costs " + b.getPriceBook()));
    }


        // update book in DB
    public void updateBookByPrice(){
        bookDao.updatePriceByISBN(book);}


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




