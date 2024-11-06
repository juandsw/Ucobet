package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;

@Service
public class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

	@Override
	public void execute(UUID data) {
		
		if(ObjectHelper.isNull(data)) {
			
			throw CityIdIsNullException.create();
			
		}
		
	}
	
	

}