package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public final class RegisterNewCityDto {
	
	private String name;
	private UUID state;

	public RegisterNewCityDto(final String name, final UUID state) {
	
		setName(name);
		setState(state);
	
	}
	
	public static final RegisterNewCityDto create(final String name, final UUID state) {
		
		return new RegisterNewCityDto(name, state);
		
	}
	
	public final UUID getState() {
		
		return state;
		
	}
	
	private final void setState(final UUID state) {
		
		this.state = UUIDHelper.getDefault(state, UUIDHelper.generate());
		
	}
	
	public final String getName() {
		
		return name;
		
	}
	
	public final void setName(final String name) {
		
		this.name = TextHelper.getDefault(name, TextHelper.EMPTY);
		
	}

	
}
