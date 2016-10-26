package com.web.models;

import com.web.entities.AccountsEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vladimir on 24.10.2016.
 */
public class CardModel {
    private Long id;
    @NotNull
    private Long numberCard;
    @NotNull
    private Integer vcc;
    @Size(min=3, max=30)
    private String type;
    private Long accountsEntity;

    public CardModel() {
    }

    public CardModel(Long id, Long numberCard, Integer vcc, String type, Long accountsEntity) {
        this.id = id;
        this.numberCard = numberCard;
        this.vcc = vcc;
        this.type = type;
        this.accountsEntity = accountsEntity;
    }

    public CardModel(Long numberCard, Integer vcc, String type, Long accountsEntity) {
        this.numberCard = numberCard;
        this.vcc = vcc;
        this.type = type;
        this.accountsEntity = accountsEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
