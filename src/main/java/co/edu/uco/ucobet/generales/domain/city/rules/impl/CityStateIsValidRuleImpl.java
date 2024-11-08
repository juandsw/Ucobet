package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CountryEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateIsNotValidRuleException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@Service
public final class CityStateIsValidRuleImpl implements CityStateIsValidRule{
	
	private StateRepository stateRepository;
	private MessageCatalogService messageCatalogService;

	public CityStateIsValidRuleImpl(StateRepository stateRepository, MessageCatalogService messageCatalogService) {
		this.stateRepository = stateRepository;
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void execute(StateDomain data) {
		var stateEntity = StateEntity.create().setId(data.getId()).setName(data.getName())
				.setCountry(CountryEntityMapper.INSTANCE.toEntity(data.getCountry()));

		var resultado = stateRepository.SelectByFilter(stateEntity);

		if (resultado.isEmpty()) {
			throw CityStateIsNotValidRuleException.create(messageCatalogService);
		}
	}

}
