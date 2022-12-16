package shopapplication.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"shopapplication.controller", "shopapplication.repository","shopapplication.project","shopapplication.service"})
public class ShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);	
	}

}
