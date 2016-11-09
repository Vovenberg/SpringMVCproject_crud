package com.web.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Vladimir on 25.10.2016.
 */
public class OperModel {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date dateOper;
    @Size(min = 3, max = 30)
    private String typeOper;
    private Long accountsEntity;

    public OperModel() {
    }

    public OperModel(Long id, Date dateOper, String typeOper, Long accountsEntity) {
        this.id = id;
        this.dateOper = dateOper;
        this.typeOper = typeOper;
        this.accountsEntity = accountsEntity;
    }

    public OperModel(Date dateOper, String typeOper, Long accountsEntity) {
        this.dateOper = dateOper;
        this.typeOper = typeOper;
        this.accountsEntity = accountsEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOper() {
        return dateOper;
    }

    public void setDateOper(Date dateOper) {
        this.dateOper = dateOper;
    }

    public String getTypeOper() {
        return typeOper;
    }

    public void setTypeOper(String typeOper) {
        this.typeOper = typeOper;
    }

    public Long getAccountsEntity() {
        return accountsEntity;
    }

    public void setAccountsEntity(Long accountsEntity) {
        this.accountsEntity = accountsEntity;
    }
}
