package com.web.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "clients", schema = "public", catalog = "Bank")
public class ClientsEntity {
    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idClient;
    @Basic
    @Column(name = "surname")
    @Size(min=3, max=30)
    private String surname;
    @Basic
    @Column(name = "pasport_n")
    @NotNull
    private Long pasportN;
    @Basic
    @Column(name = "pasport_s")
    @NotNull
    private Long pasportS;
    @Basic
    @Column(name = "street")
    @Size(min=3, max=30)
    private String street;
    @Basic
    @Column(name = "home")
    @NotNull
    private Integer home;

    @OneToMany(mappedBy = "clientsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountsEntity> accountsEntityList;

    public ClientsEntity() {
    }

    public ClientsEntity(Long id,String surname, long pasportN, long pasportS, String street, int home) {
        this.idClient=id;
        this.surname = surname;
        this.pasportN = pasportN;
        this.pasportS = pasportS;
        this.street = street;
        this.home = home;
    }

    public ClientsEntity(String surname, long pasportN, long pasportS, String street, int home) {
        this.surname = surname;
        this.pasportN = pasportN;
        this.pasportS = pasportS;
        this.street = street;
        this.home = home;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Long getPasportN() {
        return pasportN;
    }

    public void setPasportN(long pasportN) {
        this.pasportN = pasportN;
    }


    public Long getPasportS() {
        return pasportS;
    }

    public void setPasportS(long pasportS) {
        this.pasportS = pasportS;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public List<AccountsEntity> getAccountsEntityList() {
        return accountsEntityList;
    }

    public void setAccountsEntityList(List<AccountsEntity> accountsEntityList) {
        this.accountsEntityList = accountsEntityList;
    }

}
