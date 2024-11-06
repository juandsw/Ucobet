package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {

	@Override
	public void execute(StateDomain data) {
		
		if(ObjectHelper.isNull(data) || UUIDHelper.isDefault(data.getId())) {
			throw StateIdIsNullException.create();
		}
		
	}


}
