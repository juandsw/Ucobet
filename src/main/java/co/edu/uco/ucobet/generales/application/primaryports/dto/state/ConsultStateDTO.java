package co.edu.uco.ucobet.generales.application.primaryports.dto.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class ConsultStateDTO {
	
	private String name;
	private UUID country;

	public ConsultStateDTO() {
		
		setName(TextHelper.EMPTY);
		setCountry(UUIDHelper.getDefault());
		
	}

	public ConsultStateDTO(final String name, final UUID state) {
		
		setName(name);
		setCountry(state);
		
	}

	public static final ConsultStateDTO create(final String name, final UUID state) {
		return new ConsultStateDTO(name, state);
	}
	
	public static final ConsultStateDTO create() {
		return new ConsultStateDTO();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public UUID getCountry() {
		return country;
	}

	public void setCountry(final UUID country) {
		this.country = UUIDHelper.getDefault(country, UUIDHelper.getDefault());
	}
	
	

}
