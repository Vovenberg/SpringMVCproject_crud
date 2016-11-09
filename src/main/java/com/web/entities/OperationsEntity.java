package com.web.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "operations")
public class OperationsEntity {
    @Id
    @Column(name = "id_oper")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOper;
    @Basic
    @Column(name = "date_oper")
    @NotNull
    @Past
    private Date dateOper;
    @Basic
    @Column(name = "type_oper")
    @Size(min = 3, max = 30)
    private String typeOper;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private AccountsEntity accountsEntity;

    public OperationsEntity() {
    }

    public OperationsEntity(Long id, Date dateOper, String typeOper, AccountsEntity accountsEntity) {
        this.idOper = id;
        this.dateOper = dateOper;
        this.typeOper = typeOper;
        this.accountsEntity = accountsEntity;
    }

    public OperationsEntity(Date dateOper, String typeOper, AccountsEntity accountsEntity) {
        this.dateOper = dateOper;
        this.typeOper = typeOper;
        this.accountsEntity = accountsEntity;
    }

    public long getIdOper() {
        return idOper;
    }

    public void setIdOper(long idOper) {
        this.idOper = idOper;
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

    public AccountsEntity getAccountsEntity() {
        return accountsEntity;
    }

    public void setAccountsEntity(AccountsEntity accountsEntity) {
        this.accountsEntity = accountsEntity;
    }

}
