package com.resellme.resellme.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity(name = "brand")
public class Brand extends BaseModel{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id",nullable = false)
    private String id;
    @Column
    private String name;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "brandId")
    private Set<Catalog> catalogs;
}
