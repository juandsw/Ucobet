package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;

@Service
public final class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule{

	@Override
	public void execute(final UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdIsEmptyException.create();
		}
		
	}

}
