package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {
	
	private CityRepository cityRepository;
	private RegisterNewCityValidator registerNewCityValidator;
	
	public RegisterNewCityImpl(final CityRepository cityRepository, final RegisterNewCityValidator registerNewCityValidator) {
		
		this.cityRepository = cityRepository;
		this.registerNewCityValidator = registerNewCityValidator;
		
	}

	@Override
	public void execute(final CityDomain data) {
		
		//Validar reglas de negocio
		registerNewCityValidator.validate(data);
		
		var id = data.getId();
		
		//Mapper de domain a entity
		var cityEntity = CityEntity.create().setId(id).setName(data.getName()).setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
		
		//Registrar la ciudad
		cityRepository.save(cityEntity);
		
		// TODO: Challenge for you: Send notification to admin when city is created! Email information is saved in keyVault... You must retrieve email from your key vault Configuration
		//TODO: The last challenge is: I should be able to change the subject and the body of email dinamically! (Parameters 
	}

}
