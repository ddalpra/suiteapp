package it.dalpra.acme.suiteapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ErpappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpappApplication.class, args);
	}

}
