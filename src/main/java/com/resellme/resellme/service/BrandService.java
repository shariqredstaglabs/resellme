package com.resellme.resellme.service;

import com.resellme.resellme.entity.Brand;
import com.resellme.resellme.repository.projection.BrandCatalogProjection;

import java.util.List;

public interface BrandService {
    Brand add(Brand brand);
    Brand getById(String id);
    List<BrandCatalogProjection> getBrandsWithLatestCats();
}
