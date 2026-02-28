package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;

public interface GeographySearchService {

    Country findCountry(Integer countryId);

    Collection<Country> findCountries();

    Page<Country> findCountries(PagingRequest pagingRequest);

    Collection<City> findCitiesByCountry(Integer countryId);

    Page<City> findCitiesByCountry(Integer countryId, PagingRequest pagingRequest);
}
