package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;

@Service
public final class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule{

	@Override
	public void execute(final String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameFormatIsNotValidException.create();
		}
		
	}

}
