package in.app;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBannerApp {

	public static void main(String[] args) {
		
		SpringApplication app=new SpringApplication();
		app.setBannerMode(Mode.CONSOLE);
		
		@SuppressWarnings("static-access")
		ConfigurableApplicationContext ctx =app.run(SpringBannerApp.class, args);
		ctx.close();
	}

}
