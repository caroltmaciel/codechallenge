package com.github.caroltmaciel.codechallenge.repository;

import com.github.caroltmaciel.codechallenge.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
