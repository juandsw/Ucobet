package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;

@Service
public final class CityIdDoesNotExistRuleImpl implements CityIdDoesNotExistRule{

	 private CityRepository cityRepository;
	 
	 public CityIdDoesNotExistRuleImpl(final CityRepository cityRepository) {
		 this.cityRepository = cityRepository;
	 }
	 
	@Override
	public final void execute(final UUID data) {
		if(cityRepository.existsById(data)) {
			throw CityIdDoesNotExistException.create();
		}
	}

}
