package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.tcs.beans.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static List<Product> productsDb = new ArrayList<Product>();

	@Override
	public Product store(Product product) {
		product.setProductId(productsDb.size() + 1);
		productsDb.add(product);
		return product;
	}
 
	@Override
	public Product fetchProductById(int productId) throws ProductNotFoundException {
		Optional<Product> option = productsDb.stream()
				.filter(product -> product.getProductId() == productId)
				.findAny().orElse(null);
		if(option!=null){
			return option;
		}
		throw new ProductNotFoundException("Sorry product with id : "+id+" not found!");
	}

	@Override
	public void deleteProductById(int productId) throws ProductNotFoundException {
		Product product = fetchProductById(productId);
		productsDb.remove(product);
	}

	@Override
	public Product updateProductPrice(int productId, double price) throws ProductNotFoundException {
		Product product = fetchProductById(productId);
		product.setPrice(price);
		return product;
	}

	@Override
	public List<Product> fetchProducts() {
		return productsDb;
	}
	
}
