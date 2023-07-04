package str.project.airwaysbe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;
    @Column(name = "seat_availability", nullable = false)
    private int seatAvailability;
    private String source;
    private String destination;
    @Column(name = "dept_time", nullable = false)
    private String deptTime;
    private String arrTime;
    @Column(name = "flight_name", nullable = false)
    private String flightName;
    @Column(name = "seat_rate", nullable = false)
    private int seatRate;

    public void display(){

        System.out.println("**************************************************************************");
        System.out.println(id);
        System.out.println(flightNumber);
        System.out.println(seatAvailability);
        System.out.println(source);
        System.out.println(destination);
        System.out.println(deptTime);
        System.out.println(arrTime);
        System.out.println(flightName);
        System.out.println("**************************************************************************");
    }
}

    // id 
    // flight_number
    // seat_availability
    // source
    // destination
    // dept_time
    // arr_time
    // flight_name