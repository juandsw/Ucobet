package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsUniqueForStateException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsUniqueForStateRule;

@Service
public class CityNameIsUniqueForStateRuleImpl implements CityNameIsUniqueForStateRule{

private CityRepository cityRepository;
	
	public CityNameIsUniqueForStateRuleImpl(CityRepository cityRepository) {
		this.cityRepository=cityRepository;
	}
		
	@Override
	public void execute(CityDomain data) {
		
		var cityEntity=CityEntity.create().setName(data.getName()).setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
		
		var resultado = cityRepository.SelectByFilter(cityEntity);
		
		if (!resultado.isEmpty()) {
			throw CityNameIsUniqueForStateException.create();
		}
		

	}

	

}
