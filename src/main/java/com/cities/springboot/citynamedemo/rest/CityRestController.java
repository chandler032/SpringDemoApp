package com.cities.springboot.citynamedemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cities.springboot.citynamedemo.entity.City;
import com.cities.springboot.citynamedemo.exception.CityNotFoundException;
import com.cities.springboot.citynamedemo.service.CityService;

@RestController
@RequestMapping("/api")
public class CityRestController {

	private CityService cityService;
	
	@Autowired
	public CityRestController (CityService theCityService) {
		cityService=theCityService;
	}
	
	@GetMapping("/cities")
	public Page<City> findAll(@PageableDefault(size=10, page=0) Pageable pageable){
		Page<City> page= cityService.findAll( pageable);
		return page;
	}
	
	@GetMapping("/cities/{cityName}")
	public Page<City> findByName(@PathVariable String cityName, @PageableDefault(size=10, page=0) Pageable pageable){
		
			Page<City> page=cityService.findByName(cityName, pageable);
			if(page.getTotalElements() <1) {
				throw new CityNotFoundException("City not found");
			}
			return page;			
	}	
}
