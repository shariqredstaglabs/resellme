package com.resellme.resellme.service;

import com.resellme.resellme.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getByBrandId(String brandId,Integer page,Integer size );
}
