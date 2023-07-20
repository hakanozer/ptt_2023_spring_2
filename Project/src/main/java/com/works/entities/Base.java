package com.works.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.works.utils.Rest;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class Base {

    @CreatedBy
    @JsonIgnore
    private String createdBy;

    @LastModifiedBy
    @JsonIgnore
    private String lastModifiedBy;

    @CreatedDate
    @JsonIgnore
    private Long createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Long lastModifiedDate;

    @PreUpdate
    public void edit() {
        this.setLastModifiedDate(new Date().getTime());
        //this.setLastModifiedBy(Rest.userOptional(req).get());
    }

}
