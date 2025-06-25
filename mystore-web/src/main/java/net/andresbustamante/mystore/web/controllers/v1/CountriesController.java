package net.andresbustamante.mystore.web.controllers.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<CityPage> findCitiesByCountry(final Integer id) {
        var cities = geographySearchService.findCitiesByCountry(id);

        CityPage page = new CityPage();
        page.setPage(0);
        page.setNumberOfElements(cities.size());
        page.setTotalElements(cities.size());
        page.setCities(cityDtoMapper.map(cities));

        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<CountryPage> findCountries() {
        var countries = geographySearchService.findCountries();

        CountryPage page = new CountryPage();
        page.setPage(0);
        page.setNumberOfElements(countries.size());
        page.setTotalElements(countries.size());
        page.setCountries(countryDtoMapper.map(countries));

        return ResponseEntity.ok(page);
    }
}
