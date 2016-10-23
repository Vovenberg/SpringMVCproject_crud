package com.web.entities;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "filials", schema = "public", catalog = "Bank")
public class FilialsEntity {
    @Id
    @Column(name = "id_filial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFilial;
    @Basic
    @Column(name = "region")
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Past @NotNull
    private Date region;
    @Basic
    @Column(name = "street")
    @Size(min=3, max=30)
    private String street;
    @Basic
    @Column(name = "home")
    @NotNull
    private Integer home;
    @OneToMany(mappedBy = "filialsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountsEntity> accountsEntityList;

    public FilialsEntity() {
    }


    public long getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(long idFilial) {
        this.idFilial = idFilial;
    }


    public Date getRegion() {
        return region;
    }

    public void setRegion(Date region) {
        this.region = region;
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


}
