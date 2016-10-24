package com.web.models;

import com.web.entities.AccountsEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vladimir on 24.10.2016.
 */
public class CardModel {
    @NotNull
    private Long numberCard;
    @NotNull
    private Integer vcc;
    @Size(min=3, max=30)
    private String type;
    @NotNull
    private Long accountsEntity;

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public Integer getVcc() {
        return vcc;
    }

    public void setVcc(Integer vcc) {
        this.vcc = vcc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAccountsEntity() {
        return accountsEntity;
    }

    public void setAccountsEntity(Long accountsEntity) {
        this.accountsEntity = accountsEntity;
    }
}
