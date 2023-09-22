package jdbc.project.user;

import hibernate.project.HomePag;
import jdbc.project.order.OrderTest;

import java.util.Scanner;

public class UserController {
    // CRUD orders user
    public void userOrderCRUD(){
        System.out.println();
//        System.out.println("What do you want to find?");

        Scanner sc= new Scanner((System.in));
        OrderTest orderTest= new OrderTest();


        do{
            System.out.println("What do you want to do?");
            System.out.println("1. Buy a new book\n" +
                    "2. Show all orders\n" +
                    "3. Show the order by id\n"+
                    "4. Modify the content of an order\n"+
                    "5. Cancel an order\n" +
                    "6. Go back to the Home Page");

            System.out.println("Enter your choice: ");

            int choice= sc.nextInt();
            switch (choice){
                case 1: orderTest.addOrder();
                    break;
                case 2: orderTest.getListOfOrders();
                    break;
                case 3: orderTest.getOrderById();
                    break;
                case 4: orderTest.updateContentById();
                    break;
                case 5: orderTest.deleteOrderById();
                    break;
                case 6:  HomePag hp= new HomePag();
                    hp.homePag();
                    break;
                default:
                    System.out.println("Enter a valid choice!!!");
                    break;

            }
        }
        while (true);

    }
}
