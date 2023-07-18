package easyAutomate.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"easyAutomate.controller", 
		"easyAutomate.data", 
		"easyAutomate.repository"})
public class EasyAutomate {

	public static void main(String[] args) {
		SpringApplication.run(EasyAutomate.class, args);
	}
}
