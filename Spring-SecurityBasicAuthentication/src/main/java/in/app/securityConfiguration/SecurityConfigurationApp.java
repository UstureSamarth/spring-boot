package in.app.securityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationApp {

	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request -> request.requestMatchers("/api/bank/", "/api/bank/aboutus", "/login").permitAll().anyRequest().authenticated())
				.formLogin();
		SecurityFilterChain o = http.build();
		System.out.println(o.getClass().getName());
		return o;
	}

}
