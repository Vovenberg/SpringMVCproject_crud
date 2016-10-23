package com.web.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "cards", schema = "public", catalog = "Bank")
public class CardsEntity {
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCard;
    @Basic
    @Column(name = "number_card")
    @NotNull
    private Long numberCard;
    @Basic
    @Column(name = "vcc")
    @NotNull
    private Integer vcc;
    @Basic
    @Column(name = "type")
    @Size(min=3, max=30)
    private String type;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    @NotNull
    private AccountsEntity accountsEntity;

    public CardsEntity() {
    }


    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }


    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }


    public Integer getVcc() {
        return vcc;
    }

    public void setVcc(int vcc) {
        this.vcc = vcc;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountsEntity getAccountsEntity() {
        return accountsEntity;
    }

    public void setAccountsEntity(AccountsEntity accountsEntity) {
        this.accountsEntity = accountsEntity;
    }


}
