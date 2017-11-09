package pongpon.springframework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BigramApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BigramApplication.class);
//		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
