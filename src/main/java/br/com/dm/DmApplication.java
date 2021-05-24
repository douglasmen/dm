package br.com.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.dm")
public class DmApplication {
	public static void main(String... args) {
		SpringApplication.run(DmApplication.class, args);
	}
}