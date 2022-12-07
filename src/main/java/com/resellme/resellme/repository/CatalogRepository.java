package com.resellme.resellme.repository;

import com.resellme.resellme.entity.Catalog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog,String> {
    List<Catalog> findByBrandId(String brandId, Pageable pageable);
}
