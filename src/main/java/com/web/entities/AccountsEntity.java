package com.web.entities;

import com.web.models.AccModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "accounts")
public class AccountsEntity {
    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAccount;
    @Basic
    @Column(name = "date_begin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date dateBegin;
    @Basic
    @Column(name = "date_close")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date dateClose;
    @OneToMany(mappedBy = "accountsEntity")
    private Set<OperationsEntity> operationsEntityList;

    @OneToMany(mappedBy = "accountsEntity")
    private Set<CardsEntity> cardsEntityList;

    @ManyToOne
    @JoinColumn(name = "id_filial")
    private FilialsEntity filialsEntity;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientsEntity clientsEntity;


    public AccountsEntity() {
    }

    public AccountsEntity(Date dateBegin, Date dateClose, FilialsEntity filialsEntity, ClientsEntity clientsEntity) {
        this.dateBegin = dateBegin;
        this.dateClose = dateClose;
        this.filialsEntity = filialsEntity;
        this.clientsEntity = clientsEntity;
    }

    public AccountsEntity(Long id, Date dateBegin, Date dateClose, ClientsEntity clientsEntity, FilialsEntity filialsEntity) {
        this.idAccount = id;
        this.dateBegin = dateBegin;
        this.dateClose = dateClose;
        this.clientsEntity = clientsEntity;
        this.filialsEntity = filialsEntity;
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

    public AccModel getModel() {
        return new AccModel(dateBegin, dateClose, filialsEntity.getIdFilial(), clientsEntity.getIdClient());
    }

    public Set<OperationsEntity> getOperationsEntityList() {
        return operationsEntityList;
    }

    public void setOperationsEntityList(Set<OperationsEntity> operationsEntityList) {
        this.operationsEntityList = operationsEntityList;
    }

    public Set<CardsEntity> getCardsEntityList() {
        return cardsEntityList;
    }

    public void setCardsEntityList(Set<CardsEntity> cardsEntityList) {
        this.cardsEntityList = cardsEntityList;
    }
}
