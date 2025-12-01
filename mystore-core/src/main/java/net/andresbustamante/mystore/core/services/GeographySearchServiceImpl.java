package net.andresbustamante.mystore.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.GeographySearchService;
import net.andresbustamante.mystore.core.dao.CityDao;
import net.andresbustamante.mystore.core.dao.CountryDao;
import net.andresbustamante.mystore.core.entities.City;
import net.andresbustamante.mystore.core.entities.Country;
import net.andresbustamante.mystore.core.mappers.CityMapper;
import net.andresbustamante.mystore.core.mappers.CountryMapper;

@Service
@Transactional(readOnly = true)
public class GeographySearchServiceImpl implements GeographySearchService {

    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final CountryMapper countryMapper;
    private final CityMapper cityMapper;

    public GeographySearchServiceImpl(CountryDao countryDao, CityDao cityDao, CountryMapper countryMapper,
            CityMapper cityMapper) {
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.countryMapper = countryMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public CountryDto findCountry(final Integer countryId) {
        return countryMapper.map(countryDao.findById(countryId).orElseThrow());
    }

    @Override
    public Collection<CountryDto> findCountries() {
        List<Country> countries = countryDao.findAll();
        return countryMapper.map(countries);
    }

    @Override
    public Page<CountryDto> findCountries(final PagingRequest pagingRequest) {
        var countries = countryDao.findAll(PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return countryMapper.map(countries);
    }

    @Override
    public Collection<CityDto> findCitiesByCountry(final Integer countryId) {
        List<City> cities = cityDao.findByCountryId(countryId);
        return cityMapper.map(cities);
    }

    @Override
    public Page<CityDto> findCitiesByCountry(final Integer countryId, final PagingRequest pagingRequest) {
        var cities = cityDao.findByCountryId(countryId, PageRequest.of(pagingRequest.pageNumber(), pagingRequest.pageSize()));
        return cityMapper.map(cities);
    }
}
