package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.services;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SanitazerService {
	
	private static final Logger logger = LoggerFactory.getLogger(SanitazerService.class);
	private final PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
	
	public String sanitize(String input) {
        if (input == null) {
            logger.warn("Se trató de sanitizar una entrada que termino ser nula");
            return null; 
        }

        String sanitizedInput = policy.sanitize(input);
        logger.debug("Entrada sanitizada: {}", sanitizedInput); // Registra la salida sanitizada
        return sanitizedInput;
    }

 
}
