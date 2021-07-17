package com.example.person_address_order_product.service;


import com.example.person_address_order_product.facade.model.PersonFacadeRequest;
import com.example.person_address_order_product.persistence.PersonRepository;
import com.example.person_address_order_product.persistence.model.Address;
import com.example.person_address_order_product.persistence.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(PersonFacadeRequest request, Address address){

        Person savedPerson = personRepository.save(convertFromPersonFacadeRequestToPerson(request, address));
        return savedPerson;
    }

    public Person readById(Long id){
        return personRepository.getById(id);
    }

    public List<Person> readAll(){
        List<Person> all = personRepository.findAll();
        return all;
    }

    public Person update(Long id, PersonFacadeRequest request, Address address){
        Person byId = personRepository.getById(id);
        Person person = convertFromRequestToGivenPerson(request, address, byId);
        Person saved = personRepository.save(person);
        return saved;
    }

    public Boolean delete(Long id){
        personRepository.deleteById(id);
        return !personRepository.existsById(id);
    }

    public Address addressOfGivenPerson(Long id){
        Person byId = personRepository.getById(id);
        return byId.getAddress();
    }

    private Person convertFromRequestToGivenPerson(PersonFacadeRequest request, Address address, Person person){
        person.setFirstName(request.getFirsName());
        person.setLastName(request.getLastName());
        person.setAge(request.getAge());
        person.setAddress(address);
        return person;
    }


    private Person convertFromPersonFacadeRequestToPerson(PersonFacadeRequest request, Address address){
        Person person = new Person();
        person.setFirstName(request.getFirsName());
        person.setLastName(request.getLastName());
        person.setAge(request.getAge());
        person.setAddress(address);
        return person;
    }

}
