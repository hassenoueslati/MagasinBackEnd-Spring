package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MagasinStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagasinStockApplication.class, args);
	}

}
