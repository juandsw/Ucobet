package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper
public interface RegisterNewCityDtoMapper {
	
	RegisterNewCityDtoMapper INSTANCE = Mappers.getMapper(RegisterNewCityDtoMapper.class);
	
	@Mapping(source = "state", target = "state", qualifiedByName = "mapState")
	CityDomain toDomain(RegisterNewCityDto dto);
	
	@Named("mapState")
	default StateDomain mapState(UUID stateId) {
		
		return StateDomain.crate(stateId, null, null);
				
		
		
	}

}
