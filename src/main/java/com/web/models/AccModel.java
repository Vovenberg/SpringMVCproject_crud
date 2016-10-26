package com.web.models;

import com.web.entities.ClientsEntity;
import com.web.entities.FilialsEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Vladimir on 24.10.2016.
 */
public class AccModel {

    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date dateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Future
    private Date dateClose;
    private Long filialsEntity;
    private Long clientsEntity;

    public AccModel(Long id, Date dateBegin, Date dateClose, Long filialsEntity, Long clientsEntity) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateClose = dateClose;
        this.filialsEntity = filialsEntity;
        this.clientsEntity = clientsEntity;
    }

    public AccModel(Date dateBegin, Date dateClose, Long filialsEntity, Long clientsEntity) {
        this.dateBegin = dateBegin;
        this.dateClose = dateClose;
        this.filialsEntity = filialsEntity;
        this.clientsEntity = clientsEntity;
    }

    public AccModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
