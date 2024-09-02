package in.app.comp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {

	private Long id;
	private String name;
	private String[] skillSet;
	private List<String> projects;
	private Set<Long> mobileNumbers;
	private Map<String,Object> idDetails;
	
	

	public Map<String, Object> getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}

	public Set<Long> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<Long> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		System.out.println(projects.getClass().getName());
		this.projects = projects;
	}

	public String[] getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}

	@Autowired
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skillSet=" + Arrays.toString(skillSet) + ", projects="
				+ projects + ", mobileNumbers=" + mobileNumbers + ", idDetails=" + idDetails + ", company=" + company
				+ "]";
	}

}
