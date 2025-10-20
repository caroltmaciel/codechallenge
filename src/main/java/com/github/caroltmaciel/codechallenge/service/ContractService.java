package com.github.caroltmaciel.codechallenge.service;

import com.github.caroltmaciel.codechallenge.domain.Contract;
import com.github.caroltmaciel.codechallenge.dto.ContractDto;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private static final String CONTRACT_NOT_FOUND = "Contract not found";

    @Autowired
    private ContractRepository repo;

    public List<Contract> findAll() {
        return repo.findAll();
    }

    public Contract findById(Long id) throws NotFoundException {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException(CONTRACT_NOT_FOUND));
    }

    public Contract insert(Contract obj) {
        return repo.insert(obj);
    }

    public void delete(Long id) throws NotFoundException {
        findById(id);
        repo.deleteById(id);
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
