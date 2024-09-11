package in.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Calling from AlertServiceRunner");
		for(String arg:args) {
			System.out.print(arg+" ");
		}
		System.out.println();
	}

}
