package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.services.SanitazerService;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageCatalogService;

@RestController
@RequestMapping("/generales/api/v1/cities")
//@CrossOrigin(origins="http://localhost:4300")

public class RegisterNewCityController {
	
	private RegisterNewCityInteractor registerNewCityInteractor;
	
	private final SanitazerService sanitazerService;
	
	@Autowired
	private MessageCatalogService messageCatalogService;
	
	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor, MessageCatalogService messageCatalogService, SanitazerService sanitazerService) {
		
		this.registerNewCityInteractor = registerNewCityInteractor;
		this.messageCatalogService = messageCatalogService;
		this.sanitazerService = sanitazerService;
		
	}
	
	@GetMapping
	public RegisterNewCityDto getDummy() {
		
		return RegisterNewCityDto.create("Rionegro", UUIDHelper.getDefault());
		
	}
	
	@PostMapping
	public ResponseEntity<CityResponse> create(@RequestBody RegisterNewCityDto city) {
	    
	    var httpStatusCode = HttpStatus.ACCEPTED;
	    var cityResponse = new CityResponse();

	    try {
	        
	        // Sanitize the name
	        String sanitizedName = sanitazerService.sanitize(city.getName());
	        // Create the sanitized city DTO
	        RegisterNewCityDto citySanitized = RegisterNewCityDto.create(sanitizedName, city.getState());
	        
	        // Use the sanitized DTO instead of the original
	        registerNewCityInteractor.execute(citySanitized);  // Usar 'citySanitized' aquí en lugar de 'city'
	        cityResponse.getMensajes().add(messageCatalogService.getMessage("createCity"));

	    } catch (final UcobetException exception) {
	        
	        httpStatusCode = HttpStatus.BAD_REQUEST;
	        cityResponse.getMensajes().add(exception.getUserMessage());
	        exception.printStackTrace();
	        
	    } catch (final Exception exception) {
	        
	        httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        var userMessage = messageCatalogService.getMessage("errorCreateCity");
	        cityResponse.getMensajes().add(userMessage);
	        exception.printStackTrace();
	        
	    }
	    
	    return new ResponseEntity<>(cityResponse, httpStatusCode);
	}


}
