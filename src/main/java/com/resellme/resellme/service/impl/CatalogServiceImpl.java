package com.resellme.resellme.service.impl;

import com.resellme.resellme.entity.Catalog;
import com.resellme.resellme.repository.CatalogRepository;
import com.resellme.resellme.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> getByBrandId(String brandId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return catalogRepository.findByBrandId(brandId,pageable);
    }
}
