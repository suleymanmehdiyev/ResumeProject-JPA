package com.company.dao.inter;

import com.company.model.City;

import java.util.List;

public interface CityDAOInter {
    List<City> getAll();
    City getById(Integer id);
    City addCity(City city);
    City updateCity(City city);
    void deleteCity(Integer id);
}
