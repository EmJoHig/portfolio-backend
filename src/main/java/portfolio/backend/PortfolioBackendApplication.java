package portfolio.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//import portfolio.backend.modelo.SecurityConfig;
//import portfolio.backend.modelo.CorsConfig;

@SpringBootApplication
//@Import({SecurityConfig.class, CorsConfig.class})
public class PortfolioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}

}
