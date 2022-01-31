package com.css862.product.catalog.exceptions;

import org.apache.camel.Exchange;

import com.css862.product.catalog.response.ProductCatalogResponse;
import com.css862.product.catalog.response.Products;

public class ProductCatalogExceptionHandler {

	public ProductCatalogResponse handleException(Exchange exchange) {
		ProductCatalogResponse response = new ProductCatalogResponse();
		 Products products = new Products();
		 products.setName("ex name");
		 products.setDescription("ex description"); 
		 response.setProducts(products);
		 
		 return response;
	}
}
