package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLengthIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsNotValidRule;

@Service
public class CityNameLengthIsNotValidRuleImpl implements CityNameLengthIsNotValidRule {

	private static final int MIN_NAME_LENGTH = 4;
	private static final int MAX_NAME_LENGTH = 30;
	
	@Override
	public void execute(String data) {
		
		if(data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			
			throw CityNameLengthIsNotValidException.create();
			
		}
		
	}

}
