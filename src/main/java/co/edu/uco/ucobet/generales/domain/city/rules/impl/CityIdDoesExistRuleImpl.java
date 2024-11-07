package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityIdDoesExistRuleImpl implements CityIdDoesExistRule{

	 private CityRepository cityRepository;
	 private MessageCatalogService messageCatalogService;
	 
	 public CityIdDoesExistRuleImpl(final CityRepository cityRepository, MessageCatalogService messageCatalogService) {
		 this.cityRepository = cityRepository;
		 this.messageCatalogService = messageCatalogService;
	 }
	 
	@Override
	public final void execute(final UUID data) {
		if(!cityRepository.existsById(data)){
			throw CityIdDoesNotExistException.create(messageCatalogService);
		}
		
	}

}
