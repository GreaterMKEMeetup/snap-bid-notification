package org.gmjm.snapbid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SnapBidRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapBidRestApplication.class, args);
	}


}
