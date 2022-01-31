package com.css862.product.catalog.resources;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.css862.product.catalog.request.ProductCatalogSearch;
import com.css862.product.catalog.resources.util.ProductCatalogResourceConstants;
import com.css862.product.catalog.response.ProductCatalogResponse;
import com.css862.product.catalog.service.ProductCatalogService;

@Resource
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductCatalogResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatalogResource.class);
	
	@Inject
	private ProductCatalogService productCatalogService;
	
	@POST
	@Path(ProductCatalogResourceConstants.GET_PRODUCTS)
	public Response getProducts(ProductCatalogSearch search) {
		LOGGER.debug("Get products for {}", search.toString());
		
		ProductCatalogResponse response = productCatalogService.getProducts(search);
		
		return Response.status(Response.Status.OK).entity(response)
				.build();
	}
}
