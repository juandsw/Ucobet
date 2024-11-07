package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.azure.security.keyvault.secrets.SecretClient;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.edu.uco.ucobet.generales.application.secondaryports.repository"})
@EntityScan(basePackages = {"co.edu.uco.ucobet.generales.application.secondaryports.entity"})
@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales" })
public class UcobetApplication implements CommandLineRunner {

    private final SecretClient secretClient;

	public UcobetApplication(SecretClient secretClient) {
		this.secretClient = secretClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(UcobetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String h2url = secretClient.getSecret("password").getValue();
		System.setProperty("password", h2url);
		System.out.println(h2url);

	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**") 
	                    .allowedOrigins("http://localhost:4300")  
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
	                    .allowedHeaders("*")
	                    .allowCredentials(true)
	                    .maxAge(3600);
	        }
	    };
	}
}
