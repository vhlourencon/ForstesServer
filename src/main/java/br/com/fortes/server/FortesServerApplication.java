package br.com.fortes.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class FortesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortesServerApplication.class, args);
	}

}
