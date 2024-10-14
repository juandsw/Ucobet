package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class DtoUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public DtoUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.DTO, rootException);
	}
	
	public static final DtoUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DtoUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final DtoUcobetException create(final String userMessage, final Exception rootException) {
		
		return new DtoUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final DtoUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new DtoUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final DtoUcobetException create( final String userMessage) {
		
		return new DtoUcobetException(userMessage, userMessage, new Exception());
	}

}

