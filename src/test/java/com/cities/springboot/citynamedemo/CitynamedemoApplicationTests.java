package com.cities.springboot.citynamedemo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.junit.Assert;
import com.cities.springboot.citynamedemo.dao.CityRepository;
import com.cities.springboot.citynamedemo.entity.City;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@SpringBootTest
class CitynamedemoApplicationTests {
	@Autowired
	CityRepository cityRepo;
	
	@Test
	public void testfindByName() {
	Page<City> theCity=cityRepo.findByNameContaining("Autauga", null);
    Assert.assertEquals(1,theCity.getTotalElements());
	}
	
	@Test
	public void testfindByState() {
	Page<City> theCity=cityRepo.findByStateContaining("AL", null);
    Assert.assertEquals(67,theCity.getTotalElements());
	}
	
	@Test
	public void testfindByStateWithInt() {
	Page<City> theCity=cityRepo.findByNameContaining("1234", null);
    Assert.assertEquals(0,theCity.getTotalElements());
	}
	
	@Test
	public void testWithURL() {
		RestAssured.baseURI = "http://localhost:8080/api/cities";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Berkshire");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 200 );
	}
	
	@Test
	public void testWithBoth() {
		RestAssured.baseURI = "http://localhost:8080/api/cities";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Berkshire,MA");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 200 );
	}
	
	@Test
	public void testWithInvalidData() {
		RestAssured.baseURI = "http://localhost:8080/api/cities";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Berkshire,123");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 404 );
	}
}
