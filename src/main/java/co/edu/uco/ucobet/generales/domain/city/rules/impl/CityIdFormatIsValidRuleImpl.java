package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdFormatIsValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;

@Service
public final class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule {

	@Override
	public final void execute(UUID data) {
		
		if(UUIDHelper.isDefault(data)) {
			
			throw CityIdFormatIsValidException.create();
			
		}
		
	
	}

}
