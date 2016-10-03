package com.web.entities;

import javax.persistence.*;
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
    private String surname;
    @Basic
    @Column(name = "pasport_n")
    private long pasportN;
    @Basic
    @Column(name = "pasport_s")
    private long pasportS;
    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "home")
    private int home;

    @OneToMany(mappedBy = "clientsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountsEntity> accountsEntityList;

    public ClientsEntity() {
    }

    public ClientsEntity(String surname, long pasportN, long pasportS, String street, int home) {

        this.surname = surname;
        this.pasportN = pasportN;
        this.pasportS = pasportS;
        this.street = street;
        this.home = home;
        accountsEntityList = new ArrayList<>();
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


    public long getPasportN() {
        return pasportN;
    }

    public void setPasportN(long pasportN) {
        this.pasportN = pasportN;
    }


    public long getPasportS() {
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

    public int getHome() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (idClient != that.idClient) return false;
        if (pasportN != that.pasportN) return false;
        if (pasportS != that.pasportS) return false;
        if (home != that.home) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (int) (pasportN ^ (pasportN >>> 32));
        result = 31 * result + (int) (pasportS ^ (pasportS >>> 32));
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + home;
        return result;
    }
}
