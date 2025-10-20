package com.github.caroltmaciel.codechallenge.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
public class Contract {

    @Id
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer costAmount;
    private LocalDateTime updateDate;


    public Contract() {
    }

    public Contract(Long id, LocalDateTime startDate, LocalDateTime endDate, Integer costAmount, LocalDateTime updateDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.costAmount = costAmount;
        this.updateDate = updateDate;
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