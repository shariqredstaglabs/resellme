package com.resellme.resellme.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resellme.resellme.entity.Catalog;
import com.resellme.resellme.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    @GetMapping("/brand-id/{id}")
    public ResponseEntity getByBrandId(@PathVariable String id, @RequestParam(required = false,defaultValue = "0") Integer page,@RequestParam(required = false,defaultValue = "10") Integer size){
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getByBrandId(id,page ,size ));
    }
    @PostMapping("/image-api")
    public ResponseEntity addCatWithImages(@RequestParam List<MultipartFile> file , @RequestParam String catalog) throws JsonProcessingException {
        Catalog catalogObj = new ObjectMapper().readValue(catalog,Catalog.class);
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.addWithImage(file,catalogObj));
    }
}
