package com.example.springboot;


public class Destination
{
	
	String city;
	String state;
	String country;
	String id;

	public Destination(String id, String city, String state, String country) {
	
	
		this.id = id;
		this.country = country;
		this.city = city;
		this.state = state;
	
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
