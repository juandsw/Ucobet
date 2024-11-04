package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsAlreadyInUseRule;

@Service
public class CityIsAlreadyInUseRuleImpl implements CityIsAlreadyInUseRule{

	private CityRepository cityRepository;
	
	public CityIsAlreadyInUseRuleImpl(final CityRepository cityRepository) {
		
		this.cityRepository = cityRepository;
		
	}
	
	@Override
	public void execute(CityDomain data) {
	
		
	}

}
