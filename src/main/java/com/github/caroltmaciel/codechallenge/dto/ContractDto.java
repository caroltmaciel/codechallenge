package com.github.caroltmaciel.codechallenge.dto;

import com.github.caroltmaciel.codechallenge.domain.Contract;

import java.time.LocalDateTime;

public class ContractDto {

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer costAmount;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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