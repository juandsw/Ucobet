package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsExcepcion;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;

public class CityIdDoesExistRuleImpl implements CityIdDoesExistRule {
	
	private CityRepository cityRepository;
	
	@Autowired
	public CityIdDoesExistRuleImpl(final CityRepository cityRepository) {
		
		this.cityRepository = cityRepository;
		
	}

	@Override
	public final void execute(final UUID data) {
		if (!cityRepository.existsById(data)) {
			
			throw CityIdDoesNotExistsExcepcion.create();
			
		}
		
	}
	
}
