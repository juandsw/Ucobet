package co.edu.uco.ucobet.generales.crosscutting.helpers;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";

	private TextHelper() {

	}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}
	
	public static final String concatenate(String... strings) {
	    final StringBuilder sb = new StringBuilder(EMPTY);
	    if (!ObjectHelper.isNull(strings)) {  // Corregido: acceso estático
	        for (final var string : strings) {
	            sb.append(applyTrim(string));
	        }
	    }
	    return sb.toString();
	}

    public static final boolean longitudMinima ( final String valor, final int longitudMinima) {
    	return applyTrim(valor).length()>=longitudMinima;
    }
    
    public static final boolean longitudMaxima ( final String valor, final int longitudMaxima) {
    	return applyTrim(valor).length()<=longitudMaxima;
    }
}
