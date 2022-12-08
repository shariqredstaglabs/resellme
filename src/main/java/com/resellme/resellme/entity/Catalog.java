package com.resellme.resellme.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id",nullable = false)
    private String id;
    @Column(length = 100)
    private String title;
    @Column(length = 500)
    private String description;
    @Column
    private String brandId;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_id")
    private List<Product> products;
    @Column
    @CreatedDate
    private LocalDateTime postDate;
}
