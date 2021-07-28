package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.repository.CityRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }

    /*
    * Code to Fetch CRUD Operations for cities, Cities By States. Implement Below methods as per this api
    * GET  /api/v1/cities -> findAllCity
    * POST /api/v1/cities -> saveCity
    * GET /api/v1/cities/{id} -> findByIdCity
    * PUT /api/v1/cities/{id} -> saveCity
    * DELETE /api/v1/cities/{id} -> deleteCity
    * PATCH /api/v1/cities/{id} -> saveCity
    * GET /api/v1/cities/{id}/state -> cityState
    * POST /api/v1/cities/{id}/state -> cityState
    * PUT /api/v1/cities/{id}/state -> cityState
    * DELETE /api/v1/cities/{id}/state -> cityState
    * PATCH /api/v1/cities/{id}/state -> cityState
    * GET /api/v1/cities/search/findByStateId -> findByStateIdCity
    * */

}
