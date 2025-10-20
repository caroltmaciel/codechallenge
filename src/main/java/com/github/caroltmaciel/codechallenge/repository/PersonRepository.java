package com.github.caroltmaciel.codechallenge.repository;

import com.github.caroltmaciel.codechallenge.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person insert(Person obj);
}
