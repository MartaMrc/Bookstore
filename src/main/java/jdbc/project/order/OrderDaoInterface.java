package jdbc.project.order;

import hibernate.project.entities.CustomOrder;

import java.util.List;

public interface OrderDaoInterface {

    List<CustomOrder> list();
}
