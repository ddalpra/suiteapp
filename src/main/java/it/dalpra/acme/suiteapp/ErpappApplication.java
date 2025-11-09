package it.dalpra.acme.suiteapp;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
public class ErpappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpappApplication.class, args);
	}

	// Inserisce il nome dell'applicazione nel ThreadContext (MDC di Log4j2) all'avvio
    @PostConstruct
    public void init() {
        // Log4j2 usa ThreadContext per il contesto diagnostico
        ThreadContext.put("appName", "WebappAdminLte-Log4j2"); 
    }

}
