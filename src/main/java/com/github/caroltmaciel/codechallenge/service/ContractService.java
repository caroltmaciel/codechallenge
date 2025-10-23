package com.github.caroltmaciel.codechallenge.service;

import com.github.caroltmaciel.codechallenge.domain.Client;
import com.github.caroltmaciel.codechallenge.domain.Contract;
import com.github.caroltmaciel.codechallenge.dto.ContractDto;
import com.github.caroltmaciel.codechallenge.dto.UpdateContractRequest;
import com.github.caroltmaciel.codechallenge.mapper.ContractMapper;
import com.github.caroltmaciel.codechallenge.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractService {
    private static final String CONTRACT_NOT_FOUND = "Contract not found";

    @Autowired
    private ContractRepository repo;

    @Autowired
    private ContractMapper mapper;

    public List<ContractDto> findAllByClient(Long clientId) {
        List<Contract> contractList = repo.findAllActiveContracts(clientId, LocalDate.now());
        List<ContractDto> contractDtoList = mapper.mapToContractDtoList(contractList);
        return contractDtoList;
    }

    public Contract insert(Long clientId, ContractDto objDto) {
        Contract contract = mapper.mapToContract(objDto);

        Client client = new Client();
        client.setId(clientId);
        contract.setClient(client);
        contract.setUpdateDate(LocalDateTime.now());
        return repo.save(contract);
    }

    @Transactional
    public void update(Long contractId, UpdateContractRequest request) {
        Integer costAmount = request.getCostAmount();

        repo.updateCostAmount(contractId, costAmount, LocalDateTime.now());
    }

    public Double getSumAmountOfAllActiveContracts(Long clientId) {
        return repo.sumAmountOfAllActiveContracts(clientId, LocalDate.now());
    }

}
