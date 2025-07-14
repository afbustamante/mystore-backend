package net.andresbustamante.mystore.api.services;

import java.util.Collection;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;

public interface GeographySearchService {

    Collection<CountryDto> findCountries();

    Page<CountryDto> findCountries(PagingRequest pagingRequest);

    Collection<CityDto> findCitiesByCountry(Integer countryId);

    Page<CityDto> findCitiesByCountry(Integer countryId, PagingRequest pagingRequest);
}
