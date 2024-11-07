package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class UseCaseUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public UseCaseUcobetException(final String technicalMessage, final String userMessage,
		 final Exception rootException) {
		super(technicalMessage, userMessage, Layer.USECASE, rootException);
	}
	
	public static final UseCaseUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new UseCaseUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final UseCaseUcobetException create(final String userMessage, final Exception rootException) {
		
		return new UseCaseUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final UseCaseUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new UseCaseUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final UseCaseUcobetException create( final String userMessage) {
		
		return new UseCaseUcobetException(userMessage, userMessage, new Exception());
	}

}

