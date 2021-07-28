package net.guides.springboot2.springboot2jpacrudexample.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Country;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    /*
    * Code to Fetch CRUD Operations for Countries, States By Countries
    * GET /api/v1/countries -> findAllCountry
    * POST /api/v1/countries -> saveCountry
    * GET /api/v1/countries/{id} -> findByIdCountry
    * PUT /api/v1/countries/{id} -> saveCountry
    * DELETE /api/v1/countries/{id} -> deleteCountry
    * PATCH /api/v1/countries/{id} -> saveCountry
    * GET /api/v1/countries/{id}/states -> countryStates
    * POST /api/v1/countries/{id}/states -> countryStates
    * PUT /api/v1/countries/{id}/states -> countryStates
    * DELETE /api/v1/countries/{id}/states -> countryStates
    * PATCH /api/v1/countries/{id}/states -> countryStates
    * GET /api/v1/countries/{id}/states/{stateId} -> countryStates
    * DELETE /api/v1/countries/{id}/states/{stateId} -> countryStates
    * */

    @GetMapping("/countries")
    @ApiOperation(value = "View all Countries ", response = Object.class)
    public ResponseEntity<List<Country>> findAllCountry(){
        return ResponseEntity.ok().body(countryRepository.findAll());
    }

    @GetMapping("/countries/{id}")
    @ApiOperation(value = "View Country by Id", response = Object.class)
    public ResponseEntity<Country> findByIdCountry(@PathVariable(value = "id") int countryId) throws ResourceNotFoundException {
        Country country = countryRepository
                            .findById(countryId)
                            .orElseThrow(() -> new ResourceNotFoundException("Record not found with id : " + countryId));
        return ResponseEntity.ok().body(country);
    }

}
