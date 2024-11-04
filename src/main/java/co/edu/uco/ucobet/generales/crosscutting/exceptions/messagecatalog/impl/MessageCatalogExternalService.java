package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.impl;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.MessageCode;

public final class MessageCatalogExternalService implements MessageCatalog {

	@Override
	public void initialize() {
		
	}

	@Override
	public String getMessageContent(MessageCode code, String... parameters) {
		return null;
	}

	@Override
	public Message getMessage(MessageCode code, String... parameters) {
		return null;
	}
	
	
	
}