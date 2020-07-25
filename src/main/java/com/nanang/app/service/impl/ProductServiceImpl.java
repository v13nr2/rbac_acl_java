package com.nanang.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanang.app.dto.ProductDto;
import com.nanang.app.entity.Product;
import com.nanang.app.repository.ProductRepository;
import com.nanang.app.service.ProductService;
import com.nanang.app.utility.Konstanta;

@Service
public class ProductServiceImpl implements ProductService {

	
	
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDto> findAllProduct() {
		// TODO Auto-generated method stub
		try {
			List<Product> listProduct = productRepository.findAll();
			List<ProductDto> listFinal = listProduct.stream().map(productFromDb -> {
				// mapping produk hasil query db ke produk dto yang akan direturn secara json
				ProductDto prod = new ProductDto();
				prod.setId(productFromDb.getId());
				prod.setName(productFromDb.getName());
				prod.setCreatedDate(productFromDb.getCreatedDate());
				prod.setCreatedBy(productFromDb.getCreatedBy());
				prod.setUpdatedDate(productFromDb.getUpdatedDate());
				prod.setUpdatedBy(productFromDb.getUpdatedBy());
				return prod;

			}).collect(Collectors.toList());// finally konvert ke list

			return listFinal;
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			return null;
		}

	}

	@Override
	public ProductDto findById(String id) {
		// TODO Auto-generated method stub
		try {
		//find 
		Product productFromDb = productRepository.getOne(id);
		//inisiasi produk baru
		ProductDto prod = new ProductDto();
		if(productFromDb != null) {
			prod.setId(productFromDb.getId());
			prod.setName(productFromDb.getName());
			prod.setCreatedDate(productFromDb.getCreatedDate());
			prod.setCreatedBy(productFromDb.getCreatedBy());
			prod.setUpdatedDate(productFromDb.getUpdatedDate());
			prod.setUpdatedBy(productFromDb.getUpdatedBy());
		}
		return prod;
		}catch(Exception e) {
			System.out.println("ERROR " + e.getMessage());
			return null;	
		}
	}

	@Override
	public List<ProductDto> searchByName(String name) {
		try {
			final String parameterSearch = "%"+name+"%";
			List<Product> listProduct = productRepository.searchByName(parameterSearch);
			List<ProductDto> listFinal = listProduct.stream().map(productFromDb -> {
				// mapping produk hasil query db ke produk dto yang akan direturn secara json
				ProductDto prod = new ProductDto();
				prod.setId(productFromDb.getId());
				prod.setName(productFromDb.getName());
				prod.setCreatedDate(productFromDb.getCreatedDate());
				prod.setCreatedBy(productFromDb.getCreatedBy());
				prod.setUpdatedDate(productFromDb.getUpdatedDate());
				prod.setUpdatedBy(productFromDb.getUpdatedBy());
				return prod;

			}).collect(Collectors.toList());// finally konvert ke list

			return listFinal;
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			return null;
		}

	}

	//save dan update dimasukkan pada satu method, agar efisien
	@Override
	public String save(ProductDto product) {
		// TODO Auto-generated method stub
		try {
		 String idParam = product.getId() ==null?"save":product.getId();
		//query product by id
		Optional<Product>  isExist = productRepository.findById(idParam);
	     String message = "";
		//jika product ada, akan menjadi proses update, 
		if(isExist.isPresent()) {
		   Product productUpdate = new Product();
		   productUpdate.setId(product.getId());
		   productUpdate.setName(product.getName());
		   productUpdate.setCreatedDate(isExist.get().getCreatedDate());
		   productUpdate.setCreatedBy(isExist.get().getCreatedBy());
		   //tanggal diupdate
		   productUpdate.setUpdatedDate(new Date());
		   productUpdate.setUpdatedBy(product.getUpdatedBy());
		   productRepository.save(productUpdate);
		   message = Konstanta.SUCCESSUPDATEDMESSAGE;
		}else {
			//jika product tidak ada, akan menjadi proses save
			
			//generated id baru, menggunakan uuid
			  String uuid = UUID.randomUUID().toString();
			  Product productSave = new Product();
			  productSave.setId(uuid);
			  productSave.setName(product.getName());
			  productSave.setCreatedDate(new Date());
			  productSave.setCreatedBy(product.getCreatedBy());
			   productRepository.save(productSave);
			   message = Konstanta.SUCCESSSAVEDMESSAGE;
		}
		
		return message;
		}catch(Exception e) {
			
			return "ERROR " + e.getMessage();
		}
	}

	@Override
	public String delete(String productID) {
		// TODO Auto-generated method stub
		try{
			productRepository.deleteById(productID);
			
			return Konstanta.SUCCESSDELETEDMESSAGE;
		}catch (Exception e) {
			// TODO: handle exception
			return "ERROR " + e.getMessage();
		}
	}

}
