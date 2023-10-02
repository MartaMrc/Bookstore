package org.example.repositories;

import org.example.entities.User;
import org.example.entities.UserProfile;
import org.example.DbConnection.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UserProfileDao {
    Scanner sc= new Scanner(System.in);

    public void getUserLoginProfile(UserProfile userProfile) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a user
            UserProfile userProfileFromDB = (UserProfile) session.get(UserProfile.class, userProfile.getId());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void saveUserLoginProfile(UserProfile userProfile){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            //
            session.save(userProfile);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//    public void logUs()  {
//        Transaction transaction = null;
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Insert the email: ");
//        String em= sc.nextLine();
//        System.out.println("Insert the pass: ");
//        String pass= sc.nextLine();
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // get user
//            UserProfile userProfile=session.get(UserProfile.class,em);
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//
//            e.printStackTrace();
//        }
//    }

}


