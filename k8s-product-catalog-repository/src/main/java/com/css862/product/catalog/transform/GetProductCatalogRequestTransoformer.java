package com.css862.product.catalog.transform;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.css862.product.catalog.request.ProductCatalogSearch;
import com.css862.product.catalog.response.ProductCatalogResponse;
import com.css862.product.catalog.response.Products;

@Component
public class GetProductCatalogRequestTransoformer {

	public void transform(ProductCatalogSearch search, Exchange exchange) {
		
		ProductCatalogResponse response = new ProductCatalogResponse();
		Products products = new Products();
		products.setName("prod name");
		products.setDescription("prod description"); response.setProducts(products);
		 
		exchange.getIn().setBody(response);
		exchange.getOut().setBody(response);
	}
}
