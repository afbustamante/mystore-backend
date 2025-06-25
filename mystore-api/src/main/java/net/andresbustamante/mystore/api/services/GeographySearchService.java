package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.CountryDto;

public interface GeographySearchService {

    Collection<CountryDto> findCountries();

    Collection<CityDto> findCitiesByCountry(Integer countryId);
}
