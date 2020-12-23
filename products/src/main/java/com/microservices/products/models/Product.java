package com.microservices.products.models;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 6560697574042159800L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Double price;

	@Column(name = "creation_date")
	@Temporal(value = TemporalType.DATE)
	private Date creationDate;
}
