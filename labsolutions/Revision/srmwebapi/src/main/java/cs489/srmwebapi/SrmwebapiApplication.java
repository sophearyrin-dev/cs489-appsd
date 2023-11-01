package cs489.srmwebapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SrmwebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmwebapiApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			// TODO
//		};
//	}

}
