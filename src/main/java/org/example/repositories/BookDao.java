package org.example.repositories;

import java.util.List;
import java.util.Scanner;

import org.example.DbConnection.HibernateUtil;
import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {

    Scanner sc= new Scanner(System.in);
    Book book= new Book();

    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the book
            session.save(book);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List < Book > getBookList() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("from Book ", Book.class).list();
    }
}

    public List <Book> getBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Enter the number to filter the list of books");
            int id=sc.nextInt();
            return session.createQuery("from Book where bookType= " + id, Book.class).list();
        }
    }


    public void findBookByISBN(int ISBN){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            //find book from db
            book = session.get(Book.class, ISBN);
            System.out.println();
            System.out.println(book.getFirstNameAuthor()+ " "+ book.getLastNameAuthor()+ " -> "
                    +book.getTitleBook()+ " costs " + book.getPriceBook());

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//    public void findBookByType(int id){
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            //find book from db
//            Book book = session.get(Book.class, id);
//                session.createQuery("select from Book  where bookType=", Book.class);
//            System.out.println();
//            System.out.println(book.getFirstNameAuthor()+ " "+ book.getLastNameAuthor()+ " -> "
//                    +book.getTitleBook()+ " costs " + book.getPriceBook());
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

    public void updatePriceByISBN(Book book) {
        System.out.println("Insert a ISBN to update the price of a book: ");
        int ISBN= sc.nextInt();

        System.out.println("Insert a new price: ");
        Double price= sc.nextDouble();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            //get book from db
            Book book1=session.get(Book.class, ISBN);
            // update the book
            book1.setPriceBook(price);
            session.update(book1);
//                session.saveOrUpdate(book1);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteBook(int ISBN) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // delete a book
            Book book= session.get(Book.class,ISBN);
            if(book!=null){
                session.remove(book);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}

