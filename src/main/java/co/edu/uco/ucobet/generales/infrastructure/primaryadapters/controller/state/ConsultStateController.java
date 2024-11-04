package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.state;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.ConsultStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.StateResponse;

@RestController
@RequestMapping("/generales/api/v1/states")
public class ConsultStateController {

	private ConsultStateInteractor consultStateInteractor;
	
	public ConsultStateController (ConsultStateInteractor consultStateInteractor) {
		this.consultStateInteractor =consultStateInteractor;
	}
	
	@GetMapping
	public ResponseEntity<StateResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var stateResponse = new StateResponse();
		
		try {
			
			var consultStateDto = ConsultStateDTO.create();
			
			stateResponse.setDatos(consultStateInteractor.execute(consultStateDto));
			stateResponse.getMensajes().add("Estados consultados exitosamente");
			
		} catch (UcobetException exception) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			stateResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
			
		} catch (Exception exception) {
			
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Error al consultar los estados";
			stateResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
			
		}
		
		return new ResponseEntity<>(stateResponse , httpStatusCode);
	}
	
}
