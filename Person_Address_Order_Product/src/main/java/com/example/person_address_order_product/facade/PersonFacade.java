package com.example.person_address_order_product.facade;

import com.example.person_address_order_product.controller.converter.Converter;
import com.example.person_address_order_product.controller.person.model.PersonRequest;
import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.facade.model.PersonFacadeRequest;
import com.example.person_address_order_product.persistence.model.Address;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.service.AddressService;
import com.example.person_address_order_product.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonFacade {


    private final AddressService addressService;
    private final PersonService personService;
    private final Converter converter;

    public PersonFacade(AddressService addressService, PersonService personService, Converter converter) {
        this.addressService = addressService;
        this.personService = personService;
        this.converter = converter;
    }


    public PersonResponse create(PersonRequest request){
        //call address service create
        Address address = addressService.create(request.getAddressRequest());
        //call person service create
        PersonFacadeRequest personFacadeRequest = convertFromPersonRequestToFacadeRequest(request);
        Person person = personService.create(personFacadeRequest, address);

        //convert to PersonResponse
        PersonResponse personResponse = converter.convertFromPersonToPersonResponse(person);
        return personResponse;
    }

    public PersonResponse readById(Long id){
        Person person = personService.readById(id);
        PersonResponse personResponse = converter.convertFromPersonToPersonResponse(person);
        return personResponse;

    }

    public List<PersonResponse> readAll(){
        List<Person> people = personService.readAll();

        List<PersonResponse> personResponses = people.stream()
                .map(each -> converter.convertFromPersonToPersonResponse(each))
                .collect(Collectors.toList());

        return personResponses;
    }

    public PersonResponse update(Long id, PersonRequest request){

        PersonFacadeRequest personFacadeRequest = convertFromPersonRequestToFacadeRequest(request);

        Address address = personService.addressOfGivenPerson(id);
        Address update = addressService.update(address.getId(), request.getAddressRequest());

        Person updatedPerson = personService.update(id, personFacadeRequest, update);
        PersonResponse personResponse = converter.convertFromPersonToPersonResponse(updatedPerson);

        return personResponse;
    }

    public Boolean delete(Long id){
        return personService.delete(id);
    }


    private PersonFacadeRequest convertFromPersonRequestToFacadeRequest(PersonRequest request){
        PersonFacadeRequest personFacadeRequest = new PersonFacadeRequest();
        personFacadeRequest.setFirsName(request.getFirstName());
        personFacadeRequest.setLastName(request.getLastName());
        personFacadeRequest.setAge(request.getAge());
        return personFacadeRequest;
    }
}
