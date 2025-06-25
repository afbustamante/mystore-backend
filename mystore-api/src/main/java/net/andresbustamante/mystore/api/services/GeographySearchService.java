package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.api.model.Country;

public interface GeographySearchService {

    Collection<Country> findCountries();

    Collection<City> findCitiesByCountry(Integer countryId);
}
