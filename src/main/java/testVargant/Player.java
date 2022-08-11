package testVargant;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
	private String name;
	private String country;
	private String role;
	@JsonProperty("price-in-crores")
	private double price_in_crores;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getPrice_in_crores() {
		return price_in_crores;
	}

	public void setPrice_in_crores(double price_in_crores) {
		this.price_in_crores = price_in_crores;
	}

	public Player(String name, String country, String role, double price_in_crores) {
		super();
		this.name = name;
		this.country = country;
		this.role = role;
		this.price_in_crores = price_in_crores;
	}

	public Player() {

	}

}
