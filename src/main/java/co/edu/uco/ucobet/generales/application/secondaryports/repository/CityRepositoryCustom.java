package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;

@Repository
public interface CityRepositoryCustom {
	
	//@Query("SELECT c FROM City c WHERE c.name = :cityName AND c.state.id = :stateId")
	List<CityEntity> SelectByFilter(CityEntity filter);

}
