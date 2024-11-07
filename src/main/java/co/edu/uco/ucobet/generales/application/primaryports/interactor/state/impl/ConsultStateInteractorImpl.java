package co.edu.uco.ucobet.generales.application.primaryports.interactor.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.ConsultStateInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.StateDtoMapper;
import co.edu.uco.ucobet.generales.application.usecase.state.ConsultState;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.DataUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
@Transactional
public class ConsultStateInteractorImpl implements ConsultStateInteractor {

	private ConsultState consultStateUseCase;
	private MessageCatalogService messageCatalogService;
	
	public ConsultStateInteractorImpl (ConsultState consultStateUseCase, MessageCatalogService messageCatalogService) {
		this.consultStateUseCase = consultStateUseCase;
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public List<ConsultStateDTO> execute(ConsultStateDTO data) {

		try {
			var stateDomain = StateDtoMapper.INSTANCE.toDomain(data);
			var resultado = consultStateUseCase.execute(stateDomain);
			return StateDtoMapper.INSTANCE.toDtoCollection(resultado);
			
		} catch (UcobetException exception) {
			var userMessage = messageCatalogService.getMessage("errorConsult");
			throw DataUcobetException.create(userMessage);
		}
		
		//messageCatalogService.getMessage("welcome")
	}

}
