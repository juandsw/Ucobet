package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsEmptyRule;

@Service
public class CityIdIsEmptyRuleImpl implements CityIdIsEmptyRule {
	
	private CityRepository cityRepository;
	
	public CityIdIsEmptyRuleImpl(final CityRepository cityRepository) {
		
		this.cityRepository = cityRepository;
		
	}

	@Override
	public void execute(UUID data) {
		
		if(!cityRepository.existsById(data)) {
			
			throw CityIdIsEmptyException.create();
			
		}

		
	}

}
