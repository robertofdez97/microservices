package com.microservices.common.models;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Item {
	private Product product;
	private Integer quantity;
}
