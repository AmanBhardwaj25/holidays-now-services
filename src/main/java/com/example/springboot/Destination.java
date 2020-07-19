package com.example.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`DESTINATIONS`")
public class Destination
{
	@Column(name="CITY")
	String city;
	
	@Column(name="STATE")
	String state;
	
	@Column(name="COUNTRY")
	String country;
	
	@Id
	@Column(name="ID")
	String id;
	
	
	  protected Destination() {}


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
	
	@Override
	  public String toString() {
	    return String.format(
	        "Destination[id='%s', city='%s', state='%s', country='%s']",
	        id, city, state, country);
	  }
	
	
	
}
