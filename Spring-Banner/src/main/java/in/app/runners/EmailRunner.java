package in.app.runners;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("From Application Runner " + Arrays.asList(args.getSourceArgs()));
		System.out.println("NonOptionArgs " + args.getNonOptionArgs());
		System.out.println("OptionArgs " + args.getOptionNames());

		Set<String> optionNames = args.getOptionNames();
		for (String optionName : optionNames) {
			System.out.println(optionName + " " + args.getOptionValues(optionName));
		}

	}

}
