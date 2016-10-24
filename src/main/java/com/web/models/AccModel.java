package com.web.models;

import com.web.entities.ClientsEntity;
import com.web.entities.FilialsEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Vladimir on 24.10.2016.
 */
public class AccModel {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull @Past
    private Date dateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull @Past
    private Date dateClose;
    @NotNull
    private Long filialsEntity;
    @NotNull
    private Long clientsEntity;

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

    public Long getFilialsEntity() {
        return filialsEntity;
    }

    public void setFilialsEntity(Long filialsEntity) {
        this.filialsEntity = filialsEntity;
    }

    public Long getClientsEntity() {
        return clientsEntity;
    }

    public void setClientsEntity(Long clientsEntity) {
        this.clientsEntity = clientsEntity;
    }
}
