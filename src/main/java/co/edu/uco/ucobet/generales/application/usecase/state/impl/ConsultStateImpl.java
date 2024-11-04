package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.ConsultState;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.DataUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public class ConsultStateImpl implements ConsultState {

	private StateRepository stateRepository;
	
	public ConsultStateImpl(StateRepository stateRepository) {
		
		if(ObjectHelper.getObjectHelper().isNull(stateRepository)) {
			
			var userMessage = "Se ha presentado un problema para consultar las ciudades";
			throw DataUcobetException.create(userMessage);
		
		}
		
		this.stateRepository = stateRepository;
		
	}
	@Override
	public List<StateDomain> execute(StateDomain data) {
		
		var stateEntity = StateEntityMapper.INSTANCE.toEntity(data);
		var resultados = stateRepository.SelectByFilter(stateEntity);
		return StateEntityMapper.INSTANCE.toDomainCollection(resultados);
		
	}

}
