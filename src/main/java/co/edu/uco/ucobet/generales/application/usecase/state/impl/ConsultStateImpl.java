package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.ConsultState;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.DataUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public class ConsultStateImpl implements ConsultState {

	private StateRepository stateRepository;
	private MessageCatalogService messageCatalogService;
	
	public ConsultStateImpl(StateRepository stateRepository, MessageCatalogService messageCatalogService) {
		
		this.messageCatalogService = messageCatalogService;
		
		if(ObjectHelper.isNull(stateRepository)) {
			
			var userMessage = messageCatalogService.getMessage("errorConsult");
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
