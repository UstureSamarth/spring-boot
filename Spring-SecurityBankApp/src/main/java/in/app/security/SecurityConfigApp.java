
package in.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sachin").password("{noop}tendulkar").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("virat").password("{noop}kohli").roles("CUSTOMER");
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfigApp.configure()");
		// authorize requests(HTTP)

		http.authorizeHttpRequests().antMatchers("/").permitAll().
				antMatchers("/offers").authenticated()
				.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
				.antMatchers("/loanApprove")
				.hasRole("MANAGER").anyRequest().authenticated().and().formLogin().and().rememberMe().and().logout()
				.and().exceptionHandling()
				.accessDeniedPage("/denied").and().sessionManagement().maximumSessions(2)
				.maxSessionsPreventsLogin(true);

		return http.build();
	}
}
