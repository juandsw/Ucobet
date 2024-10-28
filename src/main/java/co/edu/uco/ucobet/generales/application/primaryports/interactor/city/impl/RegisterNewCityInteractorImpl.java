package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {
	
	private RegisterNewCity registerNewCityUseCase;
	
	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCityUseCase) {
		
		this.registerNewCityUseCase = registerNewCityUseCase;
		
	}

	@Override
	public void execute(final RegisterNewCityDto data) {
		
		//Convertir dto TO domain
		CityDomain domain = CityDomain.crate(null, null, null);
		
		//Call usecase
		registerNewCityUseCase.execute(domain);
		
		
	}

}
