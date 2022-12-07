package com.resellme.resellme.service.impl;

import com.resellme.resellme.entity.Brand;
import com.resellme.resellme.repository.BrandRepository;
import com.resellme.resellme.repository.projection.BrandCatalogProjection;
import com.resellme.resellme.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);
    private final BrandRepository brandRepository;
    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand add(Brand brand) {
        try {
            return brandRepository.save(brand);
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Brand getById(String id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<BrandCatalogProjection> getBrandsWithLatestCats() {
        return brandRepository.findBrandWithLatestCats();
    }
}
