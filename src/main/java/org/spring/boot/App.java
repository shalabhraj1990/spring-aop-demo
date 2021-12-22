package org.spring.boot;

import org.spring.boot.aop.modal.HelloWorld;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public  CommandLineRunner init(HelloWorld helloWorld) {
		return args -> {
			helloWorld.sayHello();
			helloWorld.sayHello1();
			helloWorld.sayHello("hello world");
		};
	}
}
