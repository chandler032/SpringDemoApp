package com.cities.springboot.citynamedemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cities.springboot.citynamedemo.entity.City;

public interface CityService {
	public Page<City> findAll(Pageable pageable);
	public Page<City> findByName(String name, Pageable pageable);

}
