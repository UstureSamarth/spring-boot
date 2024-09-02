package in.app;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.app.comp.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	@Bean("dt")
	public LocalDateTime getSysDateTime() {
		System.out.println("AppConfig.getSysDateTime()");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		System.out.println(factory.getClass().getName());
		WishMessageGenerator wmg = factory.getBean(WishMessageGenerator.class);
		System.out.println(wmg.generateWishMessage("Samarth"));

		((ConfigurableApplicationContext) factory).close();
	}

}
