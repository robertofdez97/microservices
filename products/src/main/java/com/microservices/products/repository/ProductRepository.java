package com.microservices.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservices.products.models.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
