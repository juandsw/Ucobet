package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDTO;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper
public interface StateDtoMapper {
	
	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);
	
	// Mapeo de ConsultStateDTO a StateDomain
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    default StateDomain toDomain(ConsultStateDTO dto) {
        return StateDomain.create(UUID.randomUUID(), dto.getName(), mapCountry(dto.getCountry()));
    }

    // Mapeo de StateDomain a ConsultStateDTO
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToUUID")
    ConsultStateDTO toDTO(StateDomain domain);
    
    // Mapeo de colección de ConsultStateDTO a colección de StateDomain
    List<StateDomain> toDomainCollection(List<ConsultStateDTO> dtoList);
    
    // Mapeo de colección de StateDomain a colección de ConsultStateDTO
    List<ConsultStateDTO> toDTOCollection(List<StateDomain> domainCollection);

    // Método personalizado para mapear UUID a CountryDomain, anotado con @Named
    @Named("mapCountry")
    default CountryDomain mapCountry(UUID countryId) {
        return CountryDomain.create(countryId, null);
    }

    // Método personalizado para mapear CountryDomain a UUID, anotado con @Named
    @Named("mapCountryToUUID")
    default UUID mapCountryToUUID(CountryDomain country) {
        return country != null ? country.getId() : null;
    }
}
