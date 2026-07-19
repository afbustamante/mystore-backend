package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;

public interface GeographySearchService {

    Country findCountry(Integer countryId) throws ApplicationException;

    Collection<Country> findCountries() throws ApplicationException;

    Page<Country> findCountries(PagingRequest pagingRequest) throws ApplicationException;

    Collection<City> findCitiesByCountry(Integer countryId) throws ApplicationException;

    Page<City> findCitiesByCountry(Integer countryId, PagingRequest pagingRequest) throws ApplicationException;
}
