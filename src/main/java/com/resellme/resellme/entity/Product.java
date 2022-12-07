package com.resellme.resellme.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity(name = "product")
public class Product extends BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id",nullable = false)
    private String id;
    @Column
    private String code;
    @Column
    private String image;
    @Column
    private BigDecimal price;

}
