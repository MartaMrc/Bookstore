package hibernate.project.entities;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.example.order.Order;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    @OneToMany(mappedBy = "users", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<CustomOrder> orders;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;


    public User(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

//    public void addOrder(CustomOrder order){
//        if(orders==null){
//            orders=new ArrayList <>();
//        }
//        order.setUser(this);
//        orders.add(order);
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}



//        show all books
//        filter books by genre
//        buy a book + payment method

