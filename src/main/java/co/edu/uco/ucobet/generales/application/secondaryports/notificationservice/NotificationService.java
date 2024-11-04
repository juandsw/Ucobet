package co.edu.uco.ucobet.generales.application.secondaryports.notificationservice;

public interface NotificationService {
	
    void send(String to, String subject, String content);
    
}
