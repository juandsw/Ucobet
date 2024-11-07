package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule{

	 private MessageCatalogService messageCatalogService;
	 
	 public CityIdIsNotEmptyRuleImpl(MessageCatalogService messageCatalogService) {
		 this.messageCatalogService = messageCatalogService;
	 }
	@Override
	public void execute(final UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdIsEmptyException.create(messageCatalogService);
		}
		
	}

}
