package net.andresbustamante.mystore.web.controllers.v1;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.model.City;
import net.andresbustamante.mystore.api.model.Country;
import net.andresbustamante.mystore.api.util.Page;
import net.andresbustamante.mystore.api.util.PagingRequest;
import net.andresbustamante.mystore.api.services.GeographySearchService;
import net.andresbustamante.mystore.web.dto.v1.CityPage;
import net.andresbustamante.mystore.web.dto.v1.CountryDto;
import net.andresbustamante.mystore.web.dto.v1.CountryPage;
import net.andresbustamante.mystore.web.mappers.v1.CityDtoMapper;
import net.andresbustamante.mystore.web.mappers.v1.CountryDtoMapper;

@RestController
@RequestMapping("/api/v1")
public class CountriesController extends AbstractController implements CountriesApi {

    private final GeographySearchService geographySearchService;
    private final CountryDtoMapper countryDtoMapper;
    private final CityDtoMapper cityDtoMapper;

    protected CountriesController(
            final ObjectMapper objectMapper, final HttpServletRequest request,
            final GeographySearchService geographySearchService, final CountryDtoMapper countryDtoMapper,
            final CityDtoMapper cityDtoMapper) {
        super(objectMapper, request);

        this.geographySearchService = geographySearchService;
        this.countryDtoMapper = countryDtoMapper;
        this.cityDtoMapper = cityDtoMapper;
    }

    @Override
    public ResponseEntity<CityPage> findCitiesByCountry(final Integer id, final Integer pageNumber, final Integer pageSize) {
        Page<City> cities = geographySearchService.findCitiesByCountry(id, PagingRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(cityDtoMapper.map(cities));
    }

    @Override
    public ResponseEntity<CountryPage> findCountries(final Integer pageNumber, final Integer pageSize) {
        Page<Country> countries = geographySearchService.findCountries(PagingRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(countryDtoMapper.map(countries));
    }

    @Override
    public ResponseEntity<CountryDto> findCountry(final Integer id) {
        return ResponseEntity.ok(countryDtoMapper.map(geographySearchService.findCountry(id)));
    }
}
