package com.microservices.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.models.Product;
import com.microservices.products.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRespository;

	@Override
	@Transactional()
	public <S extends Product> S save(S entity) {
		return productRespository.save(entity);
	}

	@Override
	@Transactional()
	public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
		return productRespository.saveAll(entities);
	}

	@Override
	@Transactional()
	public Optional<Product> findById(Long id) {
		return productRespository.findById(id);
	}

	@Override
	@Transactional()
	public boolean existsById(Long id) {
		return productRespository.existsById(id);
	}

	@Override
	@Transactional()
	public Iterable<Product> findAll() {
		return productRespository.findAll();
	}

	@Override
	@Transactional()
	public Iterable<Product> findAllById(Iterable<Long> ids) {
		return productRespository.findAllById(ids);
	}

	@Override
	@Transactional()
	public long count() {
		return productRespository.count();
	}

	@Override
	@Transactional()
	public void deleteById(Long id) {
		productRespository.deleteById(id);

	}

	@Override
	@Transactional()
	public void delete(Product entity) {
		productRespository.delete(entity);
	}

	@Override
	@Transactional()
	public void deleteAll(Iterable<? extends Product> entities) {
		productRespository.deleteAll();
	}

	@Override
	@Transactional()
	public void deleteAll() {
		productRespository.deleteAll();
	}

}
