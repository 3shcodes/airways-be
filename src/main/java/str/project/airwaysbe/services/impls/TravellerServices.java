package str.project.airwaysbe.services.impls;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.database.TravTable;
import str.project.airwaysbe.models.Traveller;
import str.project.airwaysbe.services.TravellerContracts;
import str.project.airwaysbe.utils.Response;

@Service
@AllArgsConstructor
public class TravellerServices implements TravellerContracts{

    private TravTable travTable;

    @Override
    public Response<Traveller> signup(Traveller user){
        
        List<Traveller> users = travTable.findByusername(user.getUsername());

        if ( users.size() != 0 ) {
            return new Response<Traveller>(null,"User already exists", HttpStatus.NOT_FOUND, false);
        }

        Traveller resUser = travTable.save(user);

        return new Response<Traveller>(resUser, "Successfully signed up", HttpStatus.OK, true);
        
    }


    @Override
    public Response<Traveller> login(Traveller user){

        List<Traveller> users = travTable.findByusername(user.getUsername());
        if( users.size()!=1 ) {
            return new Response<Traveller>(null, "No user found", HttpStatus.BAD_REQUEST, false);
        }
        Traveller resUser =  users.get(0);



        String passFromDb = resUser.getPassword();
        String passFromFe = user.getPassword();
        if( passFromDb.equals(passFromFe)!=true ) {
            return new Response<Traveller>(null, "Wrong password", HttpStatus.BAD_REQUEST, false);
        }


        return new Response<Traveller>(resUser, "Logged in successfully", HttpStatus.OK, true);
    }

    @Override
    public Response<Traveller> updUser(Traveller user){
        
        List<Traveller> users = travTable.findByusername(user.getUsername());
        if( users.size()!=1 ) {
            return new Response<Traveller>(null, "No user found", HttpStatus.BAD_REQUEST, false);
        }
        
        Traveller updUser = travTable.save(user);
        return new Response<Traveller>(updUser, "Updated User successfully", HttpStatus.OK, true);
    }

    @Override
    public Response<Traveller> delUser(String travName){

        List<Traveller> users = travTable.findByusername(travName);
        if( users.size()!=1 ) {
            return new Response<Traveller>(null, "No user found", HttpStatus.BAD_REQUEST, false);
        }

        travTable.deleteByusername(travName);

        return new Response<Traveller>(null,"Deleted User Successfully", HttpStatus.OK, true);

    }
    
}
