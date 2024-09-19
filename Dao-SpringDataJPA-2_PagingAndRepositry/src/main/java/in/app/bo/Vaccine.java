package in.app.bo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaccine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;

	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String company;
	@Column(length = 20)
	private String country;
	private Double price;
	private Integer doseCount;
	
	

	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vaccine(String name, String company, String country, Double price, Integer doseCount) {
		super();
		this.name = name;
		this.company = company;
		this.country = country;
		this.price = price;
		this.doseCount = doseCount;
	}



	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDoseCount() {
		return doseCount;
	}

	public void setDoseCount(Integer doseCount) {
		this.doseCount = doseCount;
	}

	@Override
	public String toString() {
		return "Vaccine [regNo=" + regNo + ", name=" + name + ", company=" + company + ", country=" + country
				+ ", price=" + price + ", doseCount=" + doseCount + "]";
	}

}
