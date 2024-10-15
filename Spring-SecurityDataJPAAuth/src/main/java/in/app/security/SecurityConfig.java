package in.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.app.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private IUserService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().antMatchers("/bank/").permitAll().
		antMatchers("/user/register", "/user/showLogin").permitAll().
		antMatchers("/bank/offers").authenticated().
		antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER").
		antMatchers("/bank/loanapprove").hasAuthority("MANAGER").
		anyRequest().authenticated().and().formLogin().
		defaultSuccessUrl("/bank/",true).
		loginPage("/user/showLogin").
		loginProcessingUrl("/login").
		failureUrl("/user/showLogin?error").
		and().rememberMe().and().logout().
		logoutRequestMatcher(new AntPathRequestMatcher("/signout")).
		logoutSuccessUrl("/user/showLogin?logout").and().
		exceptionHandling().accessDeniedPage("/denied").and().
		sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true)
		;

		return http.build();
	}

}
