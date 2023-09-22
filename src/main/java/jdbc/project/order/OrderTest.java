package jdbc.project.order;

import hibernate.project.entities.CustomOrder;
import jdbc.project.repositories.OrderDao;

import java.util.List;
import java.util.Scanner;

public class OrderTest {
    CustomOrder order= new CustomOrder();
    OrderDaoInterface dao= new OrderDao();
    OrderDao orderDao= new OrderDao();
    Scanner sc=new Scanner(System.in);

    public void addOrder(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = sc.nextInt();

        System.out.println("Enter the content (the title of the book): ");
        String content = sc.next();

        order.setId(id);
        order.setContent(content);
        orderDao.saveOrder(order);


        System.out.println("Your order has been registered!!!");
    }


    //get all books
    public void getListOfOrders(){

        List <CustomOrder> list = orderDao.list();

        list.forEach((orders) -> {
            System.out.println(orders.getId()+ "  " + orders.getContent() );
        });
        System.out.println();
    }




    //find order by id
    public void getOrderById(){
        System.out.println("Find all orders by id: " );

        int id= sc.nextInt();
        orderDao.findOrderById(id);
        System.out.println();
    }



    // update content order
    public void updateContentById(){
        System.out.println("Enter an id to be able to update the content of an order: ");
        int id= sc.nextInt();
        System.out.println("Enter a new content: ");
        String content= sc.nextLine();
        orderDao.updateOrderById(id, content);
        System.out.println();
    }

    //delete book by id
    public void deleteOrderById(){
        System.out.println("Insert an id to be able to delete an order: ");
        int id= sc.nextInt();
        orderDao.deleteOrderById(id);
        System.out.println();
    }
}
