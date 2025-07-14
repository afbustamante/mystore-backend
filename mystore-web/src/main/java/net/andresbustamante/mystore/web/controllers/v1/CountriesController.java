package net.andresbustamante.mystore.web.controllers.v1;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.andresbustamante.mystore.api.model.CityDto;
import net.andresbustamante.mystore.api.model.CountryDto;
import net.andresbustamante.mystore.api.model.Page;
import net.andresbustamante.mystore.api.model.PagingRequest;
import net.andresbustamante.mystore.api.services.GeographySearchService;
import net.andresbustamante.mystore.web.dto.v1.CityPage;
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
        Page<CityDto> cities = geographySearchService.findCitiesByCountry(id, PagingRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(cityDtoMapper.map(cities));
    }

    @Override
    public ResponseEntity<CountryPage> findCountries(final Integer pageNumber, final Integer pageSize) {
        Page<CountryDto> countries = geographySearchService.findCountries(PagingRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(countryDtoMapper.map(countries));
    }
}
