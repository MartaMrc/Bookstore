package jdbc.project.repositories;

import hibernate.project.entities.CustomOrder;
import jakarta.transaction.Transactional;
import jdbc.project.DbConnection.JDBCConnection;
import jdbc.project.order.OrderDaoInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements OrderDaoInterface {
    private static final String ADD_ORDER= "insert into orders values(?,?)";
    private static final String SELECT_ALL = "select * from orders";
    private static final String SELECT_BY_ID ="select * from orders where id=";
    private static final String UPDATE_ORDER="update orders set content where ISBN=?";
    private static final String DELETE_ORDER_ID ="delete from orders where id=?";


    Connection connection;

    @Transactional
    public void saveOrder(CustomOrder order) {
        connection= JDBCConnection.createDbConnection();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(ADD_ORDER);
            preparedStatement.setInt(1,order.getId());
            preparedStatement.setString(2,order.getContent());

            preparedStatement.executeUpdate();

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }


    //get books list

    public List <CustomOrder> list() {
        List<CustomOrder> ordersList = new ArrayList <CustomOrder>();
        connection = JDBCConnection.createDbConnection();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("id:"  + rs.getInt("id"));
                System.out.println("content :"  + rs.getString("content"));
                System.out.println("--------------------");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return ordersList;
    }









    public void findOrderById(int id) {
        connection= JDBCConnection.createDbConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID + id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("id:"  + rs.getInt("id"));
                System.out.println("content :"  + rs.getString("content"));
                rs.findColumn("id");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }





    //update price
    @Transactional
    public void updateOrderById(int id, String content) {
        connection= JDBCConnection.createDbConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1,content);
            preparedStatement.setInt(2,id);
            int count=preparedStatement.executeUpdate();
            if(count!=0){
                System.out.println("Updated successfully!!!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    //delete book by ISBN
    @Transactional
    public void deleteOrderById(int id) {
        connection= JDBCConnection.createDbConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_ID);
            preparedStatement.setInt(1,id);

            int count=preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
            System.out.println("Deleted successfully!!!");

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}




