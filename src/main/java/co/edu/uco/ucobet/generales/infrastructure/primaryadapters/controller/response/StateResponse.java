package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.application.primaryports.dto.state.ConsultStateDTO;

public class StateResponse extends Response<ConsultStateDTO>{
	
	public StateResponse() {
		
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
		
	}


}
