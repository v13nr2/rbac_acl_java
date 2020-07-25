package com.nanang.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nanang.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("Select p from Product p where p.name like :name")
	public List<Product> searchByName(@Param("name") String name );
	
}
