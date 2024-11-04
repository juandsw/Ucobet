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

@Service
@Transactional
public class ConsultStateInteractorImpl implements ConsultStateInteractor {

	private ConsultState consultStateUseCase;
	
	public ConsultStateInteractorImpl (ConsultState consultStateUseCase) {
		this.consultStateUseCase=consultStateUseCase;
	}

	@Override
	public List<ConsultStateDTO> execute(ConsultStateDTO data) {
		
		try {
			
			var stateDomain = StateDtoMapper.INSTANCE.toDomain(data);
			var resultado = consultStateUseCase.execute(stateDomain);
			return StateDtoMapper.INSTANCE.toDTOCollection(resultado);

		} catch (UcobetException exception) {
			
			var userMessage = "Se ha presentado un error a la hora de consultar los estados";
			throw DataUcobetException.create(userMessage);
			
		}
	}



}
