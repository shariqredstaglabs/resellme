package com.resellme.resellme.repository;

import com.resellme.resellme.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
