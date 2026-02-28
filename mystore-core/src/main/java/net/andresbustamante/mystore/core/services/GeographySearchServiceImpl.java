package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.GeographySearchService;
import net.andresbustamante.mystore.jpa.mappers.CityEntityMapper;
import net.andresbustamante.mystore.jpa.dao.CityDao;
import net.andresbustamante.mystore.jpa.dao.CountryDao;
import net.andresbustamante.mystore.jpa.entities.CityEntity;
import net.andresbustamante.mystore.jpa.entities.CountryEntity;
import net.andresbustamante.mystore.jpa.mappers.CountryEntityMapper;

@Service
@Transactional(readOnly = true)
public class GeographySearchServiceImpl implements GeographySearchService {

    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final CountryEntityMapper countryEntityMapper;
    private final CityEntityMapper cityEntityMapper;

    public GeographySearchServiceImpl(CountryDao countryDao, CityDao cityDao, CountryEntityMapper countryEntityMapper,
            CityEntityMapper cityEntityMapper) {
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.countryEntityMapper = countryEntityMapper;
        this.cityEntityMapper = cityEntityMapper;
    }

    @Override
    public Country findCountry(final Integer countryId) {
        return countryEntityMapper.map(countryDao.findById(countryId).orElseThrow());
    }

    @Override
    public Collection<Country> findCountries() {
        List<CountryEntity> countries = countryDao.findAll();
        return countryEntityMapper.map(countries);
    }

    @Override
    public Page<Country> findCountries(final PagingRequest pagingRequest) {
        var countries = countryDao.findAll(PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return countryEntityMapper.map(countries);
    }

    @Override
    public Collection<City> findCitiesByCountry(final Integer countryId) {
        List<CityEntity> cities = cityDao.findByCountryId(countryId);
        return cityEntityMapper.map(cities);
    }

    @Override
    public Page<City> findCitiesByCountry(final Integer countryId, final PagingRequest pagingRequest) {
        var cities = cityDao.findByCountryId(countryId, PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return cityEntityMapper.map(cities);
    }
}
