package net.andresbustamante.mystore.core.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.api.services.GeographySearchService;
import net.andresbustamante.mystore.core.dao.CityDao;
import net.andresbustamante.mystore.core.dao.CountryDao;
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
    public Collection<CountryDto> findCountries() {
        return countryMapper.map(countryDao.findAll());
    }

    @Override
    public Collection<CityDto> findCitiesByCountry(final Integer countryId) {
        return cityMapper.map(cityDao.findByCountryId(countryId));
    }
}
