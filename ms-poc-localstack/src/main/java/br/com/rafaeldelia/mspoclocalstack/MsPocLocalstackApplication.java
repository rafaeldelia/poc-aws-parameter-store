package br.com.rafaeldelia.mspoclocalstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.rafaeldelia.mspoclocalstack")
public class MsPocLocalstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPocLocalstackApplication.class, args);
	}
}
