package com.github.caroltmaciel.codechallenge.controller;

import com.github.caroltmaciel.codechallenge.domain.Person;
import com.github.caroltmaciel.codechallenge.dto.PersonDto;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        List<Person> list = service.findAll();
        List<PersonDto> listDto = list.stream().map(x -> new PersonDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) throws NotFoundException {
        Person obj = service.findById(id);
        return ResponseEntity.ok().body(new PersonDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PersonDto objDto) {
        Person obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody PersonDto objDto, @PathVariable Long id) throws NotFoundException {
        Person obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/birthDate")
    public ResponseEntity<Date> findBirthDate(@PathVariable Long id) throws NotFoundException {
        Person obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getBirthDate());
    }


}
