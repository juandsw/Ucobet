package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.CrosscuttingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {
	
	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public void initialize() {
		
		messages.clear();
		
		messages.put(MessageCode.M00001.getIdentificator(),
				new Message(MessageCode.M00001, "El código del mensaje que se quiere obtener del catálogo de mensajes llegó nulo"));
		messages.put(MessageCode.M00002.getIdentificator(),
				new Message(MessageCode.M00002, "Se ha presentado un problema tratando de llevar a cabo la operación deseada"));
		messages.put(MessageCode.M00003.getIdentificator(),
				new Message(MessageCode.M00003, "El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes"));
		messages.put(MessageCode.M00004.getIdentificator(), 
				new Message(MessageCode.M00004, "El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base"));
	}

	@Override
	public final String getMessageContent(MessageCode code, String... parameters) {
		return getMessage(code, parameters).getContent();
	}

	@Override
	public Message getMessage(MessageCode code, String... parameters) {
		
		if(ObjectHelper.getObjectHelper().isNull(code)) {
			
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00001);
			
			throw new CrosscuttingUcobetException(technicalMessage, userMessage, null);
			
		}
		
		if(!code.isBase()) {
			
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00004,code.getIdentificator());
			
			throw new CrosscuttingUcobetException(technicalMessage, userMessage, null);
			
		}
		
		if(!messages.containsKey(code.getIdentificator())) {
			
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00004,code.getIdentificator());
			
			throw new CrosscuttingUcobetException(technicalMessage, userMessage, null);
			
		}
		
		return messages.get(code.getIdentificator());
		
	}

}
