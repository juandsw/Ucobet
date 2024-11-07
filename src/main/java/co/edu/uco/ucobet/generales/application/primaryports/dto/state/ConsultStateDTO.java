package co.edu.uco.ucobet.generales.application.primaryports.dto.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.primaryports.dto.country.CountryDTO;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class ConsultStateDTO {
	
	private UUID id;
	private String name;
	private CountryDTO country;

	public ConsultStateDTO() {
		
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(CountryDTO.create());
		
	}

	public ConsultStateDTO(UUID id, String name, CountryDTO country) {
		
		setId(id);
		setName(name);
		setCountry(country);
		
	}

	public static final ConsultStateDTO create(UUID id, String name, CountryDTO country) {
		return new ConsultStateDTO(id, name, country);
	}
	
	public static final ConsultStateDTO create() {
		return new ConsultStateDTO();
	}
	
	public UUID getId() {
		
		return id;
		
	}
	
	public void setId(UUID id) {
		
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		this.name = TextHelper.applyTrim(name);
		
	}
	
	public CountryDTO getCountry() {
		
		return country;
	}

	public void setCountry(CountryDTO country) {
		
		this.country = ObjectHelper.getObjectHelper().getDefault(country, CountryDTO.create());
				
	
	}
	
	

}
