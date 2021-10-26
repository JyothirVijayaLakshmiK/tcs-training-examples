package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.tcs.beans.Product;
import com.tcs.service.ProductService;
import com.tcs.exception.ErrorObject;
import com.tcs.exception.ProductNotFoundException;

@RestController
@RequestMapping("product")
public class ProductRest {
 
	@Autowired
	private ProductService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product) {
		return service.store(product);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return service.fetchProducts();
	}
	// product/1, product/2, product/3
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product findProduct(@PathVariable("id") int productId) throws ProductNotFoundException {
		return service.fetchProductById(productId);
	}
	// product/1/15000
	@PutMapping(path = "{id}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProductPrice(@PathVariable("id") int id, @PathVariable("price") double price) throws ProductNotFoundException {
		return service.updateProductPrice(id, price);
	}
	@DeleteMapping(path = "{id}")
	public String deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		service.deleteProductById(id);
		// we are not sure the product is really deleting or not, this can be avoided with 
		// exceptions
		return "Product deletion";
	}

	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(ProductNotFoundException ex){
		ErrorObject eobj=new ErrorObject();
		eobj.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorObject>(eobj,HttpStatus.NOT_FOUND);
	}
}
