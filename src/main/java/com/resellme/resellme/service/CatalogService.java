package com.resellme.resellme.service;

import com.resellme.resellme.entity.Catalog;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface CatalogService {
    List<Catalog> getByBrandId(String brandId,Integer page,Integer size );
    HashMap<String,String> addWithImage(List<MultipartFile> files , Catalog catalog);
}
