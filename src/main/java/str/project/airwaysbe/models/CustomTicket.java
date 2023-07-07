package str.project.airwaysbe.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomTicket {
    
    private String username;
    private String flight_number;
    private String pnr_no;
    private int seats_booked;
    private int amount;
    private String fly_at;
    private String source;
    private String destination;
    private String dept_time;
    private String arr_time;
    private String flight_name;

}
