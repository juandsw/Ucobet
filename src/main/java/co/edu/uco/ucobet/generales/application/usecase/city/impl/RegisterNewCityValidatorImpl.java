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
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsUniqueForStateRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public final class RegisterNewCityValidatorImpl implements RegisterNewCityValidator {


	@Autowired
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	@Autowired
	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
	@Autowired
	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
	//private CityStateIsValidRule cityStateIsValidRule;
	@Autowired
	private CityIdIsNotNullRule cityIdIsNotNullRule;
	@Autowired
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	@Autowired
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	@Autowired
	private CityNameLengthIsValidRule cityNameLengthIsValidRule;
	@Autowired
	private CityNameIsUniqueForStateRule cityNameIsUniqueForStateRule;
	@Autowired
	private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
	@Autowired
	private StateIdIsNotNullRule stateIdIsNotNullRule;
	@Autowired
	private StateDoesExistRule stateDoesExistRule;
	@Autowired
	private CityIsNotBeingUsedRule cityIsNotBeingUsedRule;
	

	
	@Override
	public void validate(CityDomain data) {
		
		data.generateId();
		
		try {
			
		cityIdDoesNotExistRule.execute(data.getId());
		cityIsNotBeingUsedRule.execute(data);
			
		} catch (CityIdDoesExistException exception) {
			
			validate(data);
		
		}
		
		validateRulesRelatedWithId(data.getId());
		validateRulesRelatedWithName(data);
		validateRulesRelatedWithState(data.getState());
		
	}
	
	private void validateRulesRelatedWithId(final UUID id) {
		System.out.println("Id de la ciudad en RegisterNewCityValidator"+id);
		cityIdIsNotNullRule.execute(id);
		cityIdDoesNotExistRule.execute(id);
		cityIdFormatIsValidRule.execute(id);
		cityIdIsNotEmptyRule.execute(id);
		
		
	}

	private void validateRulesRelatedWithName(final CityDomain data) {
		
		System.out.println("Nombre de la ciudad en RegisterNewCityValidator"+data.getName());
		
		cityNameIsNotEmptyRule.execute(data.getName());
		cityNameIsNotNullRule.execute(data.getName());
		cityNameFormatIsValidRule.execute(data.getName());
		cityNameLengthIsValidRule.execute(data.getName());
		cityNameIsUniqueForStateRule.execute(data);
		
	}
	
	private void validateRulesRelatedWithState(final StateDomain state) {
		
		System.out.println("Id del estado en RegisterNewCityValidator"+state.getId());
		stateIdIsNotNullRule.execute(state);
		//cityStateIsValidRule.execute(state);
		stateDoesExistRule.execute(state.getId());
		
	}
}
