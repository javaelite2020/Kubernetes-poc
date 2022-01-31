package com.css862.product.catalog.configuration;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.css862.product.catalog.resources.ProductCatalogResource;

@Configuration
@ComponentScan
@ImportResource("classpath:camel-config.xml")
public class ProductCatalogConfiguration {

	@Inject
	private SpringBus springBus;
	
	@Inject
	private JsonMessageBodyHandler jsonMessageBodyHandler;
	
	@Bean
	public JsonMessageBodyHandler jsonMessageBodyHandler() {
		return new JsonMessageBodyHandler();
	}
	
	@Bean(name="productCatalogResources")
	public List<Object> getProductCatalogResources() {
		return Arrays.asList(productCatalogResource());
	}
	
	@Bean
	public ProductCatalogResource productCatalogResource() {
		return new ProductCatalogResource();
	}
	
	@Bean
	public Server jaxRsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		
		endpoint.setBus(springBus);
		endpoint.setAddress("/");
		endpoint.setServiceBean(getProductCatalogResources());
		endpoint.setProviders(Arrays.asList(jsonMessageBodyHandler));
		return endpoint.create();
		
	}
}
