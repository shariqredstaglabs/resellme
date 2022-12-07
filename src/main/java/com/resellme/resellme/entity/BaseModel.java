package com.resellme.resellme.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class BaseModel implements Serializable {
    @Column
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    @Column
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return  Objects.equals(creationDate, baseModel.creationDate) &&  Objects.equals(lastModifiedDate, baseModel.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash( creationDate,  lastModifiedDate);
    }
}
