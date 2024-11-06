package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;

@Service
public class CityIdDoesNotExistRuleImpl implements CityIdDoesNotExistRule {
	
	@Autowired
	private CityRepository cityRepository;
	
	public CityIdDoesNotExistRuleImpl(final CityRepository cityRepository) {
		
		this.cityRepository = cityRepository;
		
	}

	@Override
	public void execute(UUID data) {
		
		// Log para verificar el valor de data
		System.out.println("Verificando si la ciudad con ID " + data + " existe...");
		
		if(cityRepository.existsById(data)) {
			
			throw CityIdDoesExistException.create();
			
		}
		
	}

}
