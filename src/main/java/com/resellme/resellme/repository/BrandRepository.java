package com.resellme.resellme.repository;

import com.resellme.resellme.entity.Brand;
import com.resellme.resellme.repository.projection.BrandCatalogProjection;
import com.resellme.resellme.utils.NativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,String> {
    @Query(value = NativeQueries.BRANDS_WITH_LATEST_CATS,nativeQuery = true)
    List<BrandCatalogProjection> findBrandWithLatestCats();
}
