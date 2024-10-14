package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class DomainUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public DomainUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.DOMAIN, rootException);
	}
	
	public static final DomainUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DomainUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final DomainUcobetException create(final String userMessage, final Exception rootException) {
		
		return new DomainUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final DomainUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new DomainUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final DomainUcobetException create( final String userMessage) {
		
		return new DomainUcobetException(userMessage, userMessage, new Exception());
	}

}