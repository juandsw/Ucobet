package co.edu.uco.ucobet.generales.application.primaryports.dto.country;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class CountryDTO {
	
	private UUID id;

	private String name;

	public CountryDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}

	public CountryDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public static final CountryDTO create(final UUID id, final String name) {
		return new CountryDTO(id, name);
	}

	public static final CountryDTO create() {
		return new CountryDTO();
	}

	public final String getName() {
		return name;
	}

	private final void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

}
