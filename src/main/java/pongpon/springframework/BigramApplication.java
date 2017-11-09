package pongpon.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class BigramApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BigramApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		exit(0);
	}
}
