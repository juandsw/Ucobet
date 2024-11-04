package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.impl.MessageCatalogBase;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.impl.MessageCatalogExternalService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();
	
	static {
		
		initialize();
		
	}
	
	private MessageCatalogStrategy() {
		
		super();
		
	}
	
	public static void initialize() {
		
		base.initialize();
		externalService.initialize();
		
	}
	
	private static final MessageCatalog getStrategy(final boolean isBase) {
		
		return isBase ? base : externalService;
		
	}
	
	public static final Message getMessage(final MessageCode code, final String...parameters) {
		
		if(ObjectHelper.isNull(code)) {
			
			var userMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var technicalMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00001);
			
			throw new CrosscuttingUcobetException(userMessage, technicalMessage, null);
			
		}
		
		return getStrategy(code.isBase()).getMessage(code, parameters);
		
		
	}
	
	public static final String getMessageContent(final MessageCode code, final String...parameters) {
		
		return getMessage(code, parameters).getContent();
	
	}

}
