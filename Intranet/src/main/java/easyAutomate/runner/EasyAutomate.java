package easyAutomate.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EnableAutoConfiguration
public class EasyAutomate {

	public static void main(String[] args) {
		SpringApplication.run(EasyAutomate.class, args);
	}
}
