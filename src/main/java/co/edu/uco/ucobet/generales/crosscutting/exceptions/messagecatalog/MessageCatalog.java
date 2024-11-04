package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data.Message;

public interface MessageCatalog {
	
	void initialize();
	
	String getMessageContent(final MessageCode code, final String...parameters);
	
	Message getMessage(final MessageCode code, final String...parameters);

}
