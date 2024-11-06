package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;

@Service
public final class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule{

	@Override
	public void execute(final UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create();
		}
		
	}

}
