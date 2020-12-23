package com.microservices.products.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservices.models.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
