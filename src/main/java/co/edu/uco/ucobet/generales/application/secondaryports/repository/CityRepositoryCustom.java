package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;

@Repository
public interface CityRepositoryCustom {
	
	List<CityEntity> SelectByFilter(CityEntity filter);



}
