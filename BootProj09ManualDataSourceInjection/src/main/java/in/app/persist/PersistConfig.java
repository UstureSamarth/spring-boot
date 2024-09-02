package in.app.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class PersistConfig {

	@Autowired
	private Environment env;

	@Bean
	public ComboPooledDataSource createDS() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		ds.setUser(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}
}
