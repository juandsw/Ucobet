package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule{
	
	 private MessageCatalogService messageCatalogService;
	 
	 public CityNameIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		 this.messageCatalogService = messageCatalogService;
	 }
	@Override
	public void execute(final String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyException.create(messageCatalogService);
		}
		
	}

}
