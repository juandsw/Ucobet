package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;

public final class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule {

	@Override
	public final void execute(final UUID data) {
		if(ObjectHelper.isNull(data));
		throw CityIdIsEmptyException.create();
	}

}
