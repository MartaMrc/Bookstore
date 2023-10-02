package org.example.repositories;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import org.example.DbConnection.HibernateUtil;
import org.example.entities.Book;
import org.example.entities.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class OrdersDao {
    Orders orders= new Orders();


    public void saveOrder(Orders orders) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the order
            session.save(orders);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void findOrderById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            //find order
            orders = session.get(Orders.class, id);
            System.out.println();
            System.out.println(orders.getContent()+ " ");

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteOrderById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // delete an order
             orders= session.get(Orders.class,id);
            if(orders!=null){
                session.remove(orders);
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
