package in.app.comp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "org.app")
public class Company {

	private String name;
	private String type;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Company.setName()");
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		System.out.println("Company.setType()");
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		System.out.println("Company.setLocation()");
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", type=" + type + ", location=" + location + "]";
	}

}
