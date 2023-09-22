package hibernate.project.repositories;

import java.util.List;
import java.util.Scanner;

import hibernate.project.DbConnection.HibernateUtil;
import hibernate.project.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;



    public class BookDao {

        Scanner sc= new Scanner(System.in);
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

        public List < Book > getBooks() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("from Book", Book.class).list();
            }
        }


        public void findBookByISBN(int ISBN){
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // start a transaction
                transaction = session.beginTransaction();
                //find book from db
                Book book = session.get(Book.class, ISBN);
//                session.createQuery("from Book ", Book.class);
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
