package com.nanang.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nanang.app.dto.ProductDto;
import com.nanang.app.model.DataResponse;
import com.nanang.app.service.ProductService;
import com.nanang.app.utility.Konstanta;;

@RestController()
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("all")
	public ResponseEntity<List<ProductDto>> findAll(){
	   List<ProductDto> list = productService.findAllProduct();
	   return new ResponseEntity<List<ProductDto>>(list,HttpStatus.OK);
		
		
	}
	
	@GetMapping("search/{cari}")
	public ResponseEntity<List<ProductDto>> search(@PathVariable("cari") String search){
	   List<ProductDto> list = productService.searchByName(search);
	   return new ResponseEntity<List<ProductDto>>(list,HttpStatus.OK);
		
		
	}
	@PostMapping("save")
	public ResponseEntity<DataResponse> save(@RequestBody ProductDto dto){
		String message = productService.save(dto);
		DataResponse response = new DataResponse();
		response.setStatus(Konstanta.SUCCESSHTTPOK);
		response.setMessage(message);
		return new ResponseEntity<DataResponse>(response,HttpStatus.OK);
		
	}
	@PostMapping("update")
	public ResponseEntity<DataResponse> update(@RequestBody ProductDto dto){
		String message = productService.save(dto);
		DataResponse response = new DataResponse();
		response.setStatus(Konstanta.SUCCESSHTTPOK);
		response.setMessage(message);
		return new ResponseEntity<DataResponse>(response,HttpStatus.OK);
		
	}
	@GetMapping("byId/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable("id") String id){
		final String idParam = id ==null? "kosong": id;
		ProductDto byId = productService.findById(idParam);
		return new ResponseEntity<ProductDto>(byId,HttpStatus.OK);
		
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<DataResponse> delete(@PathVariable("id") String id){
		final String idParam = id ==null? "kosong": id;
		String message = productService.delete(id);
		DataResponse response = new DataResponse();
		response.setStatus(Konstanta.SUCCESSHTTPOK);
		response.setMessage(message);
		return new ResponseEntity<DataResponse>(response,HttpStatus.OK);
		
	}
	
	
	@GetMapping("admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<DataResponse> deleteT(){
		String message = "ADMIN";
		DataResponse response = new DataResponse();
		response.setStatus(Konstanta.SUCCESSHTTPOK);
		response.setMessage(message);
		return new ResponseEntity<DataResponse>(response,HttpStatus.OK);
		
	}
	@GetMapping("adminsuper")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DataResponse> deleteTG(){
		String message = "ADMIN_SUPER";
		DataResponse response = new DataResponse();
		response.setStatus(Konstanta.SUCCESSHTTPOK);
		response.setMessage(message);
		return new ResponseEntity<DataResponse>(response,HttpStatus.OK);
		
	}
	
}
