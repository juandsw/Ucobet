package co.edu.uco.ucobet.generales.domain.city;

import java.util.UUID;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public class CityDomain extends Domain {
	
	private String name;
	private StateDomain state;
	
	public CityDomain(final UUID id, final String name, final StateDomain state) {
		
		super(id);
		setName(name);
		setState(state);
	}
	
	public static final CityDomain create(final UUID id, final String name, final StateDomain state) {
		return new CityDomain(id, name, state);
	}

	public final String getName() {
		return name;
	}
	
	private final void setName(String name) {
		this.name = name;
	}

	public StateDomain getState() {
		return state;
	}

	private final void setState(StateDomain state) {
		this.state = state;
	}

}
