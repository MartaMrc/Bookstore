package jdbc.project.repositories;


import hibernate.project.entities.User;
import jdbc.project.DbConnection.JDBCConnection;
import jdbc.project.user.UserController;
import jdbc.project.user.UserDaoInterface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Scanner;


@Repository
public class UserDao implements UserDaoInterface {
    Connection connection;
    PreparedStatement preparedStatement;
    User us= new User();
    Scanner sc = new Scanner(System.in);


    @Override
    public void createAccountUser(User user){
        connection= JDBCConnection.createDbConnection();

        try{
            preparedStatement= connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getPhoneNumber());
            preparedStatement.executeUpdate();


        }catch (Exception exception){
            exception.printStackTrace();

        }
    }


    @Override
    public void logUs()  {
        connection= JDBCConnection.createDbConnection();

        System.out.print("Enter the email : ");
        String email = sc.next();
        System.out.print("Enter the password : ");
        String password = sc.next();

        try{
            preparedStatement= connection.prepareStatement("select email, password, firstName from users where email='" + email + "' and password='" + password + "'");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                rs.findColumn("email");
                rs.findColumn("password");


                if(email.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    System.out.println("Authentication successful!");
                    System.out.println("-----------");
                    System.out.println("Welcome ~ " + rs.getString(3) + " ~");
//                    Order order = new Order();
//                    order.buyBooks();
                    UserController userController= new UserController();
                    userController.userOrderCRUD();
                }
                else if(email.equals(rs.getString(1))){
                    System.out.println("-----------");
                    System.out.println("Invalid Password!");

                }
                else if (password.equals(rs.getString(2))){
                    System.out.println("-----------");
                    System.out.println("Invalid Username!");

                }
                else {
                    System.out.println("-----------");
                    System.out.println("Invalid Username & Password!!!");
                }
                preparedStatement.getConnection();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
