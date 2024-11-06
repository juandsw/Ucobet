package co.edu.uco.ucobet.generales.application.primaryports.dto.city;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class RegisterNewCityDto {
	
	private String name;
	private UUID state;
	
	public RegisterNewCityDto() {
		
		setName(TextHelper.EMPTY);
		setState(UUIDHelper.getDefault());
		
	}

	public RegisterNewCityDto(final UUID id, final String name, final UUID state) {

		setName(name);
		setState(state);
	}
	
	public static final RegisterNewCityDto create(final String name, final UUID state) {
		return new RegisterNewCityDto(UUID.randomUUID(), name, state); // Genera un ID nuevo
	}

	public final UUID getState() {
		return state;
	}
	
	private void setState(final UUID state) {
		this.state = UUIDHelper.getDefault(state, UUIDHelper.getDefault());
	}
	
	public final String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
}
