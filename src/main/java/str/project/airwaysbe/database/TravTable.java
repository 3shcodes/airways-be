package str.project.airwaysbe.database;

import str.project.airwaysbe.models.Traveller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TravTable extends JpaRepository<Traveller, Integer> {

    List<Traveller> findByusername(String username);
    void deleteByusername(String username);
}
