package com.resellme.resellme.controller;

import com.resellme.resellme.entity.Brand;
import com.resellme.resellme.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brand")
public class BrandController {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getById(id));
    }
    @GetMapping("/brand-with-latest-cats")
    public ResponseEntity latestCats(){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrandsWithLatestCats());
    }

    @PostMapping
    public ResponseEntity<Brand> add(@RequestBody Brand brand){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.add(brand));
    }

}
