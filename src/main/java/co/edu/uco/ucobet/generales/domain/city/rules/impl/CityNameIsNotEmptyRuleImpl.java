package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;

@Service
public final class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule{

	@Override
	public void execute(final String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyException.create();
		}
		
	}

}
