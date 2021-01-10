package com.microservices.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservices.common.models.Product;

public interface ProductsRepository extends PagingAndSortingRepository<Product, Long>{

}
