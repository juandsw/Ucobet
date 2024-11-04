package co.edu.uco.ucobet.generales.domain.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

public class StateDomain extends Domain {
	
	private String name;
	private CountryDomain country;
	
	public StateDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
		setName(name);
		setCountry(country);
	}
	
	public static final StateDomain create(final UUID id, final String name, final CountryDomain country) {
		return new StateDomain(id, name, country);
	}

	public final String getName() {
		return name;
	}
	
	private final void setName(String name) {
		this.name = name;
	}

	public CountryDomain getCountry() {
		return country;
	}

	private void setCountry(final CountryDomain country) {
		this.country = country;
	}


	
	
	
	
	
	

}
