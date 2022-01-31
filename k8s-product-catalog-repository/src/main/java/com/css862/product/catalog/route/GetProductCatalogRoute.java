package com.css862.product.catalog.route;

import org.apache.camel.CamelException;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.css862.product.catalog.exceptions.ProductCatalogExceptionHandler;
import com.css862.product.catalog.transform.GetProductCatalogRequestTransoformer;
import com.css862.product.catalog.util.ProductCatalogConstants;

@Component
public class GetProductCatalogRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(CamelException.class, CamelExecutionException.class, Exception.class)
		.handled(true).bean(ProductCatalogExceptionHandler.class, "handleException");
		
		from (ProductCatalogConstants.GET_PRODUCTS_FROM_ROUTE)
			.routeId("requestProductCatalogId")
			.bean(GetProductCatalogRequestTransoformer.class, ProductCatalogConstants.TRANSFORM)
			.setExchangePattern(ExchangePattern.InOut)
			.to("mock:result")
		  .end() ;
		
	}

	
}
