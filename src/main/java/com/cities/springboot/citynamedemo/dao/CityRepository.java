package com.cities.springboot.citynamedemo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cities.springboot.citynamedemo.entity.City;

public interface CityRepository extends JpaRepository<City, String> {

	Page<City> findByNameContaining(String name, Pageable pageable);

	Page<City> findByStateContaining(String name, Pageable pageable);

	Page<City> findByStateAndNameContaining(String string, String string2, Pageable pageable);

}
