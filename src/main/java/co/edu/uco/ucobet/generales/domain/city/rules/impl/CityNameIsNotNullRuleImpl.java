package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule{

	 private MessageCatalogService messageCatalogService;
	 
	 public CityNameIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		 this.messageCatalogService = messageCatalogService;
	 }
	@Override
	public void execute(final String data) {
		if(TextHelper.isNull(data)) {
			throw CityNameIsNullException.create(messageCatalogService);
		}
		
	}

}
