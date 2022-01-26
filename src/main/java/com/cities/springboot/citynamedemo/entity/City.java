package com.cities.springboot.citynamedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class  City{
	
	@Id
	@Column(name="fips")
	private String fips;
	
	@Column(name="state")
	private String state;
	
	@Column(name="name")
	private String name;

	public City() {
		
	}
	public City(String fips, String state, String name) {
		this.fips = fips;
		this.state = state;
		this.name = name;
	}
	public String getFips() {
		return fips;
	}
	public void setFips(String fips) {
		this.fips = fips;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "City [fips=" + fips + ", state=" + state + ", name=" + name + "]";
	}
	
}
