package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public final class RegisterNewCityValidatorImpl implements RegisterNewCityValidator {

	@Override
	public void validate(CityDomain data) {
		// TODO Auto-generated method stub
		
	}

//	@Autowired
//	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
//	@Autowired
//	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
//	@Autowired
//	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
//	@Autowired
//	private CityStateIsValidRule cityStateIsValidRule;
//	@Autowired
//	private CityIdIsNotNullRule cityIdIsNotNullRule;
//	@Autowired
//	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
//	@Autowired
//	private CityNameIsNotNullRule cityNameIsNotNullRule;
//	@Autowired
//	private CityNameLengthIsValidRule cityNameLengthIsValidRule;
//	
//
//	
//	@Override
//	public void validate(CityDomain data) {
//		
//		data.generateId();
//		
//		try {
//			
//		cityIdDoesNotExistRule.execute(data.getId());
//			
//		} catch (CityIdDoesExistException exception) {
//			
//			validate(data);
//		
//		}
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
//		cityIdIsNotNullRule.execute(id);
//		
//	}
//
//	private void validateRulesRelatedWithName(final CityDomain data) {
//		
//		cityNameFormatIsValidRule.execute(data.getName());
//		cityNameIsNotNullRule.execute(data.getName());
//		cityNameLengthIsValidRule.execute(data.getName());
//		
//	}
//	
//	private void validateRulesRelatedWithState(final StateDomain state) {
//		
//		cityStateIsValidRule.execute(state);
//		
//	}
}
