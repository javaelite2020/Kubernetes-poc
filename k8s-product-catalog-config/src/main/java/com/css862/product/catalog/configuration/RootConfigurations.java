package com.css862.product.catalog.configuration;

import java.util.Properties;

import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.ConfigurationConverter;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages="com.css862.product.catalog")
public class RootConfigurations {

//	@Inject 
//	private CombinedConfiguration config;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer (CombinedConfiguration config) {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setProperties(ConfigurationConverter.getProperties(config));
		return configurer;
	}
	
	
	@Bean(name = "properties")
	public PropertiesComponent properties() {
		PropertiesComponent propertiesComponent = new PropertiesComponent();
		propertiesComponent.setLocation("ref:camelPlaceholders");
		return propertiesComponent;
	}
	
	@Bean(name = "camelPlaceholders")
	public Properties camelPlaceholders(CombinedConfiguration config) {
		return ConfigurationConverter.getProperties(config);
	}
	
	@Bean
	public GsonDataFormat jsonProvider () {
		return new GsonDataFormat();
	}
	
	@Bean (name="cxf", destroyMethod="shutdown") 
	public SpringBus springBus() {
		SpringBus sprBus = new SpringBus();
		sprBus.setProperty("skip.default.json.provider.regsitration", "true");
		return sprBus;
	}
}
