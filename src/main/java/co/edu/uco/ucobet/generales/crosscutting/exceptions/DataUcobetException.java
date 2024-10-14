package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class DataUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public DataUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.DATA, rootException);
	}
	
	public static final DataUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DataUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final DataUcobetException create(final String userMessage, final Exception rootException) {
		
		return new DataUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final DataUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new DataUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final DataUcobetException create( final String userMessage) {
		
		return new DataUcobetException(userMessage, userMessage, new Exception());
	}

}