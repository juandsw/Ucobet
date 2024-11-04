package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsUniqueForStateRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public final class RegisterNewCityValidatorImpl implements RegisterNewCityValidator {

	@Override
	public void validate(CityDomain data) {
		// TODO Auto-generated method stub
	}

	
//	@Autowired
//	private CityIdDoesExistRule cityIdDoesExistRule;
//	@Autowired
//	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
//	@Autowired
//	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
//	@Autowired
//	private CityNameIsUniqueForStateRule cityNameIsUniqueForStateRule;
//	@Autowired
//	private CityStateIsValidRule cityStateIsValidRule;
//	
//
//	
//	@Override
//	public void validate(final CityDomain data) {
//		
//		validateRulesRelatedWithId(data.getId());
//		validateRulesRelatedWithName(data);
//		validateRulesRelatedWithState(data.getState());
//		
//	}
//	
//	private void validateRulesRelatedWithId(final UUID id) {
//		
//		cityIdDoesNotExistRule.execute(id);
//		cityIdFormatIsValidRule.execute(id);
//		cityIdIsNotEmptyRule.execute(id);
//		
//	}
//
//	private void validateRulesRelatedWithName(final CityDomain data) {
//		cityNameIsUniqueForStateRule.execute(data);
//		
//	}
//	
//	private void validateRulesRelatedWithState(final StateDomain state) {
//		cityStateIsValidRule.execute(state);
//	}
}
