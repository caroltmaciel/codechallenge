package com.github.caroltmaciel.codechallenge.service;

import com.github.caroltmaciel.codechallenge.domain.Person;
import com.github.caroltmaciel.codechallenge.dto.PersonDto;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final String PERSON_NOT_FOUND = "Person not found";

    @Autowired
    private PersonRepository repo;

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person findById(Long id) throws NotFoundException {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(PERSON_NOT_FOUND));
    }

    public Person insert(Person obj) {
        return repo.insert(obj);
    }

    public void delete(Long id) throws NotFoundException {
        findById(id);
        repo.deleteById(id);
    }

    public Person update(Person obj) throws NotFoundException {
        Person newObj = repo.findById(obj.getId()).orElseThrow(() -> new NotFoundException(PERSON_NOT_FOUND));
        updateData(newObj, obj);
        return repo.save(newObj);
    }


    private void updateData(Person newObj, Person obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public Person fromDTO(PersonDto objDto) {
        return new Person(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
