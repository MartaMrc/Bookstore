package hibernate.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name= "profile")
public class UserProfile {
    @Id
    @Transient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Id
    private String email;

    private String password;

    public UserProfile( String password) {
        this.password = password;
    }
}
