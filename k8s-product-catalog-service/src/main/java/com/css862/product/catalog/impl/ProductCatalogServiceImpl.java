package com.css862.product.catalog.impl;

import javax.inject.Inject;

import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import com.css862.product.catalog.request.ProductCatalogSearch;
import com.css862.product.catalog.response.ProductCatalogResponse;
import com.css862.product.catalog.service.ProductCatalogService;
import com.css862.product.catalog.util.ProductCatalogConstants;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Inject
	private ProducerTemplate template;
//	
	@Override
	public ProductCatalogResponse getProducts(ProductCatalogSearch search) {

		return template.requestBodyAndHeaders(ProductCatalogConstants.GET_PRODUCTS_FROM_ROUTE, search, null, ProductCatalogResponse.class);
//		ProductCatalogResponse response = new ProductCatalogResponse();
//		 
//		 Products products = new Products();
//		 products.setName(search.getProduct().getProductName());
//		 products.setDescription("some description"); response.setProducts(products);
//		 
//		 return response;
	}
}