package com.example.person_address_order_product.controller.person;

import com.example.person_address_order_product.controller.person.model.PersonRequest;
import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.facade.PersonFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonFacade personFacade;

    public PersonController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }


    //create
    @PostMapping(value = "/person")
    public ResponseEntity<PersonResponse> create(@RequestBody PersonRequest request){
        ResponseEntity<PersonResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(personFacade.create(request));
        return body;
    }

    //read
    @GetMapping(value = "/person/{id}")
    public ResponseEntity<PersonResponse> readById(@PathVariable Long id){
        ResponseEntity<PersonResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(personFacade.readById(id));
        return body;
    }

    //readAll
    @GetMapping(value = "/person")
    public ResponseEntity<List<PersonResponse>> readAll(){
        ResponseEntity<List<PersonResponse>> body = ResponseEntity.status(HttpStatus.CREATED).body(personFacade.readAll());
        return body;
    }

    //update
    @PutMapping(value = "/person/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id, @RequestBody PersonRequest request){
        ResponseEntity<PersonResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(personFacade.update(id, request));
        return body;
    }

    //delete
    @DeleteMapping(value = "person/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        ResponseEntity<Boolean> body = ResponseEntity.status(HttpStatus.CREATED).body(personFacade.delete(id));
        return body;
    }

}
