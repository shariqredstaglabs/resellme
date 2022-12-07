package com.resellme.resellme.controller;

import com.resellme.resellme.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
