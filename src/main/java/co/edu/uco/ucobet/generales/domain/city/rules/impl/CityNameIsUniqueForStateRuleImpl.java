package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsUniqueForStateRule;

@Service
public final class CityNameIsUniqueForStateRuleImpl implements CityNameIsUniqueForStateRule{

	@Override
	public void execute(CityDomain data) {
		
	}

}
