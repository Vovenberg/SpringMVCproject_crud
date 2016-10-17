package com.web.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Entity
@Table(name = "filials", schema = "public", catalog = "Bank")
public class FilialsEntity {
    @Id
    @Column(name = "id_filial")
    private long idFilial;
    @Basic
    @Column(name = "region")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date region;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "home")
    private int home;
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


    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilialsEntity that = (FilialsEntity) o;

        if (idFilial != that.idFilial) return false;
        if (home != that.home) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idFilial ^ (idFilial >>> 32));
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + home;
        return result;
    }
}
