package co.edu.uco.ucobet.generales.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
}
