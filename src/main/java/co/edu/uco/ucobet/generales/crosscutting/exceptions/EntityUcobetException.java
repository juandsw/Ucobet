package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class EntityUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public EntityUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.ENTITY, rootException);
	}
	
	public static final EntityUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new EntityUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final EntityUcobetException create(final String userMessage, final Exception rootException) {
		
		return new EntityUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final EntityUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new EntityUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final EntityUcobetException create( final String userMessage) {
		
		return new EntityUcobetException(userMessage, userMessage, new Exception());
	}

}

