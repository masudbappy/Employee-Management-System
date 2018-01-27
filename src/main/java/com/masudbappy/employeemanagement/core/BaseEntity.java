package com.masudbappy.employeemanagement.core;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    protected BaseEntity() {
        id = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    @PrePersist
    public void setCreated() {
        this.created = new Date();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @PreUpdate
    public void setLastUpdated() {
        this.lastUpdated = new Date();
    }
}
