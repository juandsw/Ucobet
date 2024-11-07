package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.notificationservice.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {
	
	private CityRepository cityRepository;
	private RegisterNewCityValidator registerNewCityValidator;
	private MessageCatalogService messageCatalogService;
	private NotificationService notificationService;
	
	@Value("${emailArrive}")
    private String emailArrive;
	
	public RegisterNewCityImpl(final CityRepository cityRepository, final RegisterNewCityValidator registerNewCityValidator, MessageCatalogService messageCatalogService, NotificationService notificationService) {
		
		this.cityRepository = cityRepository;
		this.registerNewCityValidator = registerNewCityValidator;
		this.messageCatalogService = messageCatalogService;
		this.notificationService = notificationService;
		
	}

	@Override
	public void execute(final CityDomain data) {
		
		//Validar reglas de negocio
		registerNewCityValidator.validate(data);
		
		var id = generarIdentificadorCiudad();
		System.out.println(id);
		System.out.println(data.getState().getId());
		
		//Mapper de domain a entity
		var cityEntity = CityEntity.create().setId(id).setName(data.getName()).setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
		
		//Registrar la ciudad
		cityRepository.save(cityEntity);
		
		String subject = messageCatalogService.getMessage("subject");
        String content = messageCatalogService.getMessage("content1") + data.getName() + messageCatalogService.getMessage("content2");
        notificationService.send(emailArrive, subject, content);
        
	}
	
	private final UUID generarIdentificadorCiudad() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			id = UUIDHelper.generate();
			var resultados = cityRepository.findById(id);
			existeId = !resultados.isEmpty();
		}
		
		return id;

}
	
}
