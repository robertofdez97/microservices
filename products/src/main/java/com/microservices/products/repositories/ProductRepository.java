package com.microservices.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.common.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
