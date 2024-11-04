package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data;

public final class Message {
	
	private MessageCode code;
	private String content;
	
	public Message(MessageCode code, String content) {
		
		setCode(code);
		setContent(content);
		
	}
	
	//Setters


	public void setCode(MessageCode code) {
		this.code = code;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	//Getters

	
	public final MessageCode getCode() {
		return code;
	}

	public final String getContent() {
		return content;
	}
	
	public final MessageType getType() {
		return getCode().getType();
	}
	
	public final boolean esBase() {
		return getCode().isBase();
	}
	public final String getIdentificador() {
		return getCode().getIdentificator();
	}

	
	
	
	
	
	
	
}