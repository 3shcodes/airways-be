package str.project.airwaysbe.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ticket")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "pnr_no")
    private String pnrNo;
    @Column(name = "seats_booked")
    private int seatsBooked;
    private int amount;
    @Column(name = "fly_at")
    private String flyAt;
    private String source; 
    private String destination; 
    private String dept_time;
    private String arr_time;
    private String flight_name;
    public boolean preValid() {
        if ( username.equals("") || flightNumber.equals("") || seatsBooked==0 || amount==0  ) {
            return false;
        }
        return true;
    }

    public void display(){
        System.out.println("**************************************************************************");
        System.out.println(id);
        System.out.println(username);
        System.out.println(flightNumber);
        System.out.println(pnrNo);
        System.out.println(seatsBooked);
        System.out.println(amount);
        System.out.println("**************************************************************************");
    }
}
