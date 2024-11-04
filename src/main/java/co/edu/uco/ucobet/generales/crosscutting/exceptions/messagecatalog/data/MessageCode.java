package co.edu.uco.ucobet.generales.crosscutting.exceptions.messagecatalog.data;

import static co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper.concatenate;
import static co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper.UNDERLINE;



public enum MessageCode {
	
	M00001(MessageType.TECHNICAL, MessageCategory.ERROR, "00001", true),
	M00002(MessageType.USER, MessageCategory.ERROR, "00002", true),
	M00003(MessageType.TECHNICAL, MessageCategory.ERROR, "00003", true),
	M00004(MessageType.TECHNICAL, MessageCategory.ERROR, "00004", true);
	
	
	private MessageType type;
	private MessageCategory category;
	private String code;
	private boolean base;
	
	private MessageCode(final MessageType type, final MessageCategory category, final String code, final boolean base) {
		setType(type);
		setCategory(category);
		setCode(code);
		setBase(base);
	}

	//Getters
	
	public MessageType getType() {
		return type;
	}
	
	public MessageCategory getCategory() {
		return category;
	}
	
	public String getCode() {
		return code;
	}
	
	public boolean isBase() {
		return base;
	}
	
	public String getIdentificator() {
		return concatenate(getType().name(), UNDERLINE, getCategory().toString(), UNDERLINE, getCode());
	}
	
	//Setters

	private final void setType(MessageType type) {
		this.type = type;
	}

	private final void setCategory(MessageCategory category) {
		this.category = category;
	}
	
	private final void setCode(String code) {
		this.code = code;
	}

	private final void setBase(boolean base) {
		this.base = base;
	}

}
