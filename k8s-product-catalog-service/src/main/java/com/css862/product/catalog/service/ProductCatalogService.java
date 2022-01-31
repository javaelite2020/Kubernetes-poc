package com.css862.product.catalog.service;

import org.springframework.stereotype.Service;

import com.css862.product.catalog.request.ProductCatalogSearch;
import com.css862.product.catalog.response.ProductCatalogResponse;


@Service
public interface ProductCatalogService {

	public ProductCatalogResponse getProducts(ProductCatalogSearch search);
}
