package str.project.airwaysbe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.models.Flight;
import str.project.airwaysbe.services.FlightContracts;
import str.project.airwaysbe.utils.Response;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightContracts fliServs;

    @GetMapping("/route")
    public ResponseEntity<Object> getByPlace(@RequestParam String from, @RequestParam String to) {
        
        Response<List<Flight>> resp = fliServs.getByPlace(from, to);
        return resp.send();
    }

    @GetMapping("/qbyname")
    public ResponseEntity<Object> searchByName(@RequestParam String flightName) {
        Response<List<Flight>> resp = fliServs.searchByName(flightName);
        return resp.send();
    }

    @GetMapping("/qbyplace")
    public ResponseEntity<Object> searchByPlace(@RequestParam String from, @RequestParam String to) {
        Response<List<Flight>> resp = fliServs.searchByPlace( from, to);
        return resp.send();
    }

}
