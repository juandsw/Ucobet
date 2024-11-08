package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule{
	
	 private MessageCatalogService messageCatalogService;
	 
	 public CityIdFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		 
		 this.messageCatalogService = messageCatalogService;
		 
	 }

	@Override
	public void execute(final UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create(messageCatalogService);
		}
		
	}

}
