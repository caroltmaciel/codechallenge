package com.github.caroltmaciel.codechallenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.caroltmaciel.codechallenge.domain.Contract;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContractDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer costAmount;

    @JsonIgnore
    private LocalDateTime updateDate;

    public ContractDto() {
    }

    public ContractDto(Contract obj) {
        id = obj.getId();
        startDate = obj.getStartDate();
        endDate = obj.getEndDate();
        costAmount = obj.getCostAmount();
        updateDate = obj.getUpdateDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(Integer costAmount) {
        this.costAmount = costAmount;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}