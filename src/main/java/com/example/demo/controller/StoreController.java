package com.example.demo.controller;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateStoreRequest;
import com.example.demo.dto.CreateStoreResponse;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;

@RestController
@RequestMapping( path = "/api/v1/stores", produces = MediaType.APPLICATION_JSON_VALUE )
public class StoreController
{

    @Autowired
    private StoreRepository storeRepository;

    @PostMapping
    @ResponseStatus( value = HttpStatus.CREATED )
    @CrossOrigin( exposedHeaders = { HttpHeaders.LOCATION } )
    public ResponseEntity<CreateStoreResponse> create( @Valid @NotNull @RequestBody CreateStoreRequest storeToCreateRequest )
    {
        Store storeToCreate = CreateStoreRequest.toModel( storeToCreateRequest );
        Store storeCreated = storeRepository.save( storeToCreate );
        return ResponseEntity.ok( CreateStoreResponse.fromModel( storeCreated ) );
    }

    @GetMapping( path = "/{id}" )
    public ResponseEntity<CreateStoreResponse> findById( @Valid @PathVariable( "id" ) @NotNull Long id )
    {
        Store storeFound = storeRepository.findById( id ).get();
        return ResponseEntity.ok( CreateStoreResponse.fromModel( storeFound ) );
    }
}
