package com.web.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "operations", schema = "public", catalog = "Bank")
public class OperationsEntity {
    @Id
    @Column(name = "id_oper")
    private long idOper;
    @Basic
    @Column(name = "date_oper")
    private Date dateOper;
    @Basic
    @Column(name = "type_oper")
    private String typeOper;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    private AccountsEntity accountsEntity;

    public OperationsEntity() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationsEntity that = (OperationsEntity) o;

        if (idOper != that.idOper) return false;
        if (dateOper != null ? !dateOper.equals(that.dateOper) : that.dateOper != null) return false;
        if (typeOper != null ? !typeOper.equals(that.typeOper) : that.typeOper != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOper ^ (idOper >>> 32));
        result = 31 * result + (dateOper != null ? dateOper.hashCode() : 0);
        result = 31 * result + (typeOper != null ? typeOper.hashCode() : 0);
        return result;
    }
}
