package com.github.caroltmaciel.codechallenge.mapper;

import com.github.caroltmaciel.codechallenge.domain.Contract;
import com.github.caroltmaciel.codechallenge.dto.ContractDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContractMapper {

    public List<ContractDto> mapToContractDtoList(List<Contract> list) {
        List<ContractDto> dtoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Contract contractList = list.get(i);
            ContractDto contractDto = mapToContractDto(contractList);
            dtoList.add(contractDto);
        }
        return dtoList;
    }

    public ContractDto mapToContractDto(Contract contract) {
        Long id = contract.getId();
        LocalDateTime startDate = contract.getStartDate();
        LocalDateTime endDate = contract.getEndDate();
        Integer costAmount = contract.getCostAmount();
        LocalDateTime updateDate = contract.getUpdateDate();

        ContractDto dto = new ContractDto();
        dto.setId(id);
        dto.setStartDate(startDate);
        dto.setEndDate(endDate);
        dto.setCostAmount(costAmount);
        dto.setUpdateDate(updateDate);

        return dto;
    }

    public Contract mapToContract(ContractDto dto) {
        Long id = dto.getId();
        LocalDateTime startDate = dto.getStartDate();
        LocalDateTime endDate = dto.getEndDate();
        Integer costAmount = dto.getCostAmount();
        LocalDateTime updateDate = dto.getUpdateDate();

        Contract contract = new Contract();
        contract.setId(id);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);
        contract.setCostAmount(costAmount);
        contract.setUpdateDate(updateDate);

        return contract;
    }

}
