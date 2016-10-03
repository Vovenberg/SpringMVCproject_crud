package com.web.entities;

import javafx.scene.control.Label;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "accounts", schema = "public", catalog = "Bank")
public class AccountsEntity {
    @Id
    @Column(name = "id_account")
    private long idAccount;
    @Basic
    @Column(name = "date_begin")
    private Date dateBegin;
    @Basic
    @Column(name = "date_close")
    private Date dateClose;
    @OneToMany(mappedBy = "accountsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OperationsEntity> operationsEntityList;

    @OneToMany(mappedBy = "accountsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CardsEntity> cardsEntityList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_filial")
    private FilialsEntity filialsEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private ClientsEntity clientsEntity;


    public AccountsEntity() {
    }


    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }


    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }


    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }


    public FilialsEntity getFilialsEntity() {
        return filialsEntity;
    }

    public void setFilialsEntity(FilialsEntity filialsEntity) {
        this.filialsEntity = filialsEntity;
    }


    public ClientsEntity getClientsEntity() {
        return clientsEntity;
    }

    public void setClientsEntity(ClientsEntity clientsEntity) {
        this.clientsEntity = clientsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (idAccount != that.idAccount) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateClose != null ? !dateClose.equals(that.dateClose) : that.dateClose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAccount ^ (idAccount >>> 32));
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        return result;
    }
}
