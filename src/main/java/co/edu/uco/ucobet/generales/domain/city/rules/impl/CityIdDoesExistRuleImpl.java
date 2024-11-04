package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;

@Service
public class CityIdDoesExistRuleImpl implements CityIdDoesExistRule {
	
	@Autowired
	private CityRepository cityRepository;
	
	public CityIdDoesExistRuleImpl(final CityRepository cityRepository) {
		
		this.cityRepository = cityRepository;
		
	}

	@Override
	public final void execute(final UUID data) {
		if (!cityRepository.existsById(data)) {
			
			throw CityIdDoesExistException.create();
			
		}
		
	}
	
}
