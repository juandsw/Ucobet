package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class SengridUcobetException extends UcobetException{

    private static final long serialVersionUID = 1L;

    public SengridUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
    	
        super(userMessage, technicalMessage, Layer.GENERAL, rootException);
        
    }

    public static SengridUcobetException create (final String userMessage, final String technicalMessage,
                                              final Exception rootException) {
        return new SengridUcobetException(userMessage, technicalMessage, rootException);
    }

    public static SengridUcobetException create (final String userMessage, final String technicalMessage){
        return new SengridUcobetException(userMessage, technicalMessage, new Exception());
    }
    
    public static SengridUcobetException create(final String userMessage) {
    	
    	return new SengridUcobetException(userMessage, userMessage, new Exception());
    	
    }
}
