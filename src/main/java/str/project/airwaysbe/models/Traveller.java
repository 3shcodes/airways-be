package str.project.airwaysbe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="traveller")
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private int age;
    private String dob;
    private String mobile_no;
    private String city;
    private String state;
    private String gender;

    public boolean validateSignup(){
        if ( this.username == "" || this.password == "" ) {
            return false;
        }
        return true;
    }

    public void display(){
        System.out.println("**************************************************************************");
        System.out.println(username);
        System.out.println(password);
        System.out.println("**************************************************************************");
    }
}
