package com.github.caroltmaciel.codechallenge.service;

import com.github.caroltmaciel.codechallenge.domain.Client;
import com.github.caroltmaciel.codechallenge.domain.Contract;
import com.github.caroltmaciel.codechallenge.dto.ContractDto;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.mapper.ContractMapper;
import com.github.caroltmaciel.codechallenge.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContractService {
    private static final String CONTRACT_NOT_FOUND = "Contract not found";

    @Autowired
    private ContractRepository repo;

    @Autowired
    private ContractMapper mapper;

    public void findAllByClient(Long clientId) {

    }

    public Contract insert(Long clientId, ContractDto objDto) {
        Contract contract = mapper.mapToContract(objDto);

        Client client = new Client();
        client.setId(clientId);
        contract.setClient(client);
        contract.setUpdateDate(LocalDateTime.now());
        return repo.save(contract);
    }

    public Contract update(Contract obj) throws NotFoundException {
        Contract newObj = repo.findById(obj.getId()).orElseThrow(() -> new NotFoundException(CONTRACT_NOT_FOUND));
        updateData(newObj, obj);
        return repo.save(newObj);
    }


    private void updateData(Contract newObj, Contract obj) {
        newObj.setId(obj.getId());
        newObj.setStartDate(obj.getStartDate());
        newObj.setEndDate(obj.getEndDate());
        newObj.setCostAmount(obj.getCostAmount());
        newObj.setUpdateDate(obj.getUpdateDate());
    }

    public Contract fromDTO(ContractDto objDto) {
        return new Contract(objDto.getId(), objDto.getStartDate(), objDto.getEndDate(), objDto.getCostAmount(), objDto.getUpdateDate());
    }

}
