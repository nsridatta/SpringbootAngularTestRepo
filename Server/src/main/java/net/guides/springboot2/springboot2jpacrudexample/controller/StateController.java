package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.repository.StateRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    private StateRepository stateRepository;

    public StateController(StateRepository stateRepository){
        this.stateRepository=stateRepository;
    }

    /*
    * Code to Fetch CRUD Operations for States, City By states
    *
    * GET /api/v1/states -> findAllState
    * POST /api/v1/states -> saveState
    * GET /api/v1/states/{id} -> findByIdState
    * PUT /api/v1/states/{id} -> saveState
    * DELETE /api/v1/states/{id} -> deleteState
    * PATCH /api/v1/states/{id} -> saveState
    * GET /api/v1/states/{id}/cities -> stateCities
    * POST /api/v1/states/{id}/cities -> stateCities
    * PUT /api/v1/states/{id}/cities -> stateCities
    * DELETE /api/v1/states/{id}/cities -> stateCities
    * PATCH /api/v1/states/{id}/cities -> stateCities
    * GET /api/v1/states/{id}/cities/{cityId} -> stateCities
    * DELETE /api/v1/states/{id}/cities/{cityId} -> stateCities
    * GET /api/v1/states/{id}/country -> stateCountry
    * POST /api/v1/states/{id}/country -> stateCountry
    * PUT /api/v1/states/{id}/country -> stateCountry
    * DELETE /api/v1/states/{id}/country -> stateCountry
    * PATCH /api/v1/states/{id}/country -> stateCountry
    * GET /api/v1/states/search/findByCountryCode -> findByCountryCodeState
    * */

}
