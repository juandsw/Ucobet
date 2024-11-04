package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNullRule;

@Service
public class CityNameIsNullRuleImpl implements CityNameIsNullRule {

	@Override
	public void execute(CityDomain data) {
		if(ObjectHelper.isNull(data)) {
			
			throw CityNameIsNullException.create();
			
		}
		
	}

}
