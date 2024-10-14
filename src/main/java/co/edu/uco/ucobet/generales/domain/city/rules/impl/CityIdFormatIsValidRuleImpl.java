package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;

public final class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule {

	@Override
	public final void execute(UUID data) {
		if(UUIDHelper.isDefault(data));
		throw CityIdFormatIsNotValidException.create();
	
	}

}
