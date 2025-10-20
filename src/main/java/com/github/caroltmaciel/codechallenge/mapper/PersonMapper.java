package com.github.caroltmaciel.codechallenge.mapper;

import com.github.caroltmaciel.codechallenge.domain.Person;
import com.github.caroltmaciel.codechallenge.dto.PersonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PersonMapper {

    public List<PersonDto> mapToPersonDtoList(List<Person> list) {
        List<PersonDto> dtoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Person personList = list.get(i);
            PersonDto personDto = mapToPersonDto(personList);
            dtoList.add(personDto);
        }
        return dtoList;
    }

    public PersonDto mapToPersonDto(Person person) {
        String name = person.getName();
        Integer phone = person.getPhone();
        String email = person.getEmail();
        Long id = person.getId();
        Date birthDate = person.getBirthDate();

        PersonDto dto = new PersonDto();
        dto.setName(name);
        dto.setPhone(phone);
        dto.setEmail(email);
        dto.setId(id);
        dto.setBirthDate(birthDate);

        return dto;
    }

    public Person mapToPerson(PersonDto dto) {
        String name = dto.getName();
        Integer phone = dto.getPhone();
        String email = dto.getEmail();
        Long id = dto.getId();
        Date birthDate = dto.getBirthDate();

        Person person = new Person();
        person.setName(name);
        person.setPhone(phone);
        person.setEmail(email);
        person.setId(id);
        person.setBirthDate(birthDate);

        return person;
    }

}
