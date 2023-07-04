package str.project.airwaysbe.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.models.Traveller;
import str.project.airwaysbe.services.TravellerContracts;
import str.project.airwaysbe.utils.Response;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class TravellerController {

    private TravellerContracts travServs;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup (@RequestBody Traveller user) {
        
        if (user.validateSignup()==false){
            // Response<Traveller> resp = new Response<Traveller>(null, "No username or password", HttpStatus.BAD_REQUEST, false);
            // return resp.send();
            return Response.send(null, "No username or password", HttpStatus.BAD_REQUEST, false);
        }

        Response<Traveller> resp = travServs.signup(user);
        return resp.send();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login (@RequestBody Traveller user) {
        
        if (user.validateSignup()==false){
            return Response.send(null, "No username or password", HttpStatus.BAD_REQUEST, false);
        }

        Response<Traveller> resp = travServs.login(user);
        return resp.send();

    }
    
}
