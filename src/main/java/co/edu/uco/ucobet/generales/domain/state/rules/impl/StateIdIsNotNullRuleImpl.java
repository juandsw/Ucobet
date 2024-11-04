package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {

	private StateRepository stateRepository;
	
	public StateIdIsNotNullRuleImpl(StateRepository stateRepository) {
		
		this.stateRepository = stateRepository;
		
	}
	
	
	@Override
	public void execute(StateDomain data) {
		
		var stateEntity = StateEntity.create().setId(data.getId());
		var resultados = stateRepository.SelectByFilter(stateEntity);
		if(!resultados.isEmpty()) {
			
			throw StateIdIsNullException.create();
			
			
		}
		
	}

}
