package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CountryEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public class CityStateIsValidRuleImpl implements CityStateIsValidRule {

	private StateRepository stateRepository;
	
	public CityStateIsValidRuleImpl(StateRepository stateRepository) {
		
		this.stateRepository = stateRepository;
		
	}
	
	@Override
	public void execute(StateDomain data) {
		var stateEntity = StateEntity.create().setId(data.getId()).setName(data.getName()).setCountry(CountryEntityMapper.INSTANCE.toEntity(data.getCountry()));
		var resultado = stateRepository.SelectByFilter(stateEntity);
		
		if(!resultado.isEmpty()) {
			
			throw CityStateIsNotValidException.create();
			
			
		}
	}
	
	
	

}
