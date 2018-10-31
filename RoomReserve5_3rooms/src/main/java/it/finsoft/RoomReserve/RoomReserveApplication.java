package it.finsoft.RoomReserve;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RoomReserveApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RoomReserveApplication.class, args);
	}

	@Override // what does this do?
	// @Transactional
	public void run(String... arg0) throws Exception {

	}

}