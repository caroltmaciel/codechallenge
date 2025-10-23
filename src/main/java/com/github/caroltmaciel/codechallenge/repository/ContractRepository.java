package com.github.caroltmaciel.codechallenge.repository;

import com.github.caroltmaciel.codechallenge.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Modifying
    @Query("update Contract c set c.costAmount = ?2, c.updateDate = ?3 where c.id = ?1")
    int updateCostAmount(Long contractId, Integer costAmount, LocalDateTime updateDate);

    @Query("select c from Contract c where c.client.id =?1 and c.endDate > ?2")
    List<Contract> findAllActiveContracts(Long clientId, LocalDate currentDate);

}
