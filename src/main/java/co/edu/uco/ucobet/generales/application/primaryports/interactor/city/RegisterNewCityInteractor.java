package co.edu.uco.ucobet.generales.application.primaryports.interactor.city;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.InteractorWithoutReturn;
import jakarta.transaction.Transactional;

@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithoutReturn<RegisterNewCityDto> {

}
