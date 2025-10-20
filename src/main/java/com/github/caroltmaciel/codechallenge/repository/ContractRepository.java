package com.github.caroltmaciel.codechallenge.repository;

import com.github.caroltmaciel.codechallenge.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
