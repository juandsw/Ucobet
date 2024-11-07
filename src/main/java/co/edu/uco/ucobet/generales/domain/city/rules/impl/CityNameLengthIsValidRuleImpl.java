package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLengthIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityNameLengthIsValidRuleImpl implements CityNameLengthIsValidRule{

	 private MessageCatalogService messageCatalogService;
	 
	 public CityNameLengthIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		 this.messageCatalogService = messageCatalogService;
	 }
		
		private static final int MIN_NAME_LENGTH = 5;
		private static final int MAX_NAME_LENGTH = 40;

		@Override
		public void execute(String data) {
			if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
				throw CityNameLengthIsNotValidException.create(messageCatalogService);
			
		}
		}
	}


