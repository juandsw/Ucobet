package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{

	
	private CityRepository cityRepository;
    private MessageCatalogService messageCatalogService;

    @Autowired
    public CityIsNotBeingUsedRuleImpl(CityRepository cityRepository, MessageCatalogService messageCatalogService) {
    	
        this.cityRepository = cityRepository;
        this.messageCatalogService = messageCatalogService;
        
    }

    @Override
    public void execute(CityDomain data) {
        // Convertimos CityDomain a CityEntity
        var cityEntity = CityEntity.create()
            .setName(data.getName())
            .setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

        // Verificamos si ya existe una ciudad con el mismo nombre en el estado
        var existingCities = cityRepository.SelectByFilter(cityEntity);

        if (!existingCities.isEmpty()) {
            // Lanzamos la excepción con el mensaje adecuado si ya existe la ciudad
            throw CityIsBeingUsedException.create(messageCatalogService);
        }
    }

}
