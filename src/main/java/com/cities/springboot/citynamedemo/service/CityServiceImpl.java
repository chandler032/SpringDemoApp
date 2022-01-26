package com.cities.springboot.citynamedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cities.springboot.citynamedemo.dao.CityRepository;
import com.cities.springboot.citynamedemo.entity.City;

@Service
public class CityServiceImpl implements CityService {

	private CityRepository cityRepo;

	@Autowired
	public CityServiceImpl(CityRepository theCityRepo) {
		cityRepo = theCityRepo;
	}

	@Override
	public Page<City> findAll(Pageable pageable) {
		return cityRepo.findAll(pageable);
	}

	@Override
	public Page<City> findByName(String name, Pageable pageable) {
		if (name.length() > 2) {
			if (name.indexOf(",") > 0) {
				String[] str = name.split(",");
				if (str[0] != null && str[1] != null)
					return cityRepo.findByStateAndNameContaining(str[1], str[0], pageable);
			} else
				return cityRepo.findByNameContaining(name,pageable);
		} else {
			return cityRepo.findByStateContaining(name,pageable);
		}
		return null;
	}
}
