package com.nanang.app.service;

import java.util.List;

import com.nanang.app.dto.ProductDto;;

public interface ProductService {

	List<ProductDto> findAllProduct();
	
	ProductDto findById(String id);
	
	List<ProductDto> searchByName(String name);
	String save(ProductDto product);
	String delete(String product);
	
}
