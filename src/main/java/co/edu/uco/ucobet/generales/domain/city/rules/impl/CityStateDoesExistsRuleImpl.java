package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.rules.CityStateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public final class CityStateDoesExistsRuleImpl implements CityStateDoesExistsRule{

	@Override
	public void execute(final StateDomain data) {
	}

}
