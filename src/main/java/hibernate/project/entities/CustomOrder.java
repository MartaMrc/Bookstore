package hibernate.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class CustomOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="usersId")
//    private User user;

    public CustomOrder(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Order(content=" + this.getContent() + ")";
    }
}

