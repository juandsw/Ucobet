package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

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
		
		//Mapper de domain a entity
		CityEntity cityEntity = CityEntity.create();
		
		//Registrar la ciudad
		cityRepository.save(cityEntity);
		
		// TODO: Challenge for you: Send notification to admin when city is created! Email information is saved in keyVault... You must retrieve email from your key vault Configuration
		//TODO: The last challenge is: I should be able to change the subject and the body of email dinamically! (Parameters 
	}

}
