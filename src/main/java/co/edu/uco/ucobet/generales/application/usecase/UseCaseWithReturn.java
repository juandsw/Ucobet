package co.edu.uco.ucobet.generales.application.usecase;

public interface UseCaseWithReturn<R, D> {
	
	R execute(D data);

}
