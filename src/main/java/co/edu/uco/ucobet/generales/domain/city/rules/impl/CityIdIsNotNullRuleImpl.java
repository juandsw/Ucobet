package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule{

	 private MessageCatalogService messageCatalogService;
	 
	 public CityIdIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		 this.messageCatalogService = messageCatalogService;
	 }
	@Override
	public void execute(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsNullException.create(messageCatalogService);
		}
		
	}

}
