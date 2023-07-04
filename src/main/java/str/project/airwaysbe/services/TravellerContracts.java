package str.project.airwaysbe.services;

import str.project.airwaysbe.models.Traveller;
import str.project.airwaysbe.utils.Response;

public interface TravellerContracts {

    Response<Traveller> signup(Traveller user);
    Response<Traveller> login(Traveller user);
    Response<Traveller> updUser(Traveller user);
    Response<Traveller> delUser(String travName);
}
