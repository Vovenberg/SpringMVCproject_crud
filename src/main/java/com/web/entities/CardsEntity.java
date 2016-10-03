package com.web.entities;

import javax.persistence.*;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "cards", schema = "public", catalog = "Bank")
public class CardsEntity {
    @Id
    @Column(name = "id_card")
    private long idCard;
    @Basic
    @Column(name = "number_card")
    private long numberCard;
    @Basic
    @Column(name = "vcc")
    private int vcc;
    @Basic
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    private AccountsEntity accountsEntity;

    public CardsEntity() {
    }


    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }


    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }


    public int getVcc() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardsEntity that = (CardsEntity) o;

        if (idCard != that.idCard) return false;
        if (numberCard != that.numberCard) return false;
        if (vcc != that.vcc) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCard ^ (idCard >>> 32));
        result = 31 * result + (int) (numberCard ^ (numberCard >>> 32));
        result = 31 * result + vcc;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
