package org.gameoftrones.ironbankapp;

import org.gameofthrones.ironstarter.RavenSenderApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IronBankAppApplication {

	@Bean
	public RavenSenderApplicationListener ravenSenderApplicationListener(){
		return new RavenSenderApplicationListener(){
			@Override
			public void onApplicationEvent(ContextRefreshedEvent event) {
				System.out.println("raven was sent to the dark place...");
			}
		};
	}

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(IronBankAppApplication.class, args);
	}
}
