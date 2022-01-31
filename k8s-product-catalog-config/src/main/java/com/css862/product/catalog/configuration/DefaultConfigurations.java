package com.css862.product.catalog.configuration;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;


@Configuration
@Profile("default")
public class DefaultConfigurations {

	@Bean
	public CombinedConfiguration configurations(Environment env) {
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("application.yml"));
		Properties props = yaml.getObject();
		CombinedConfiguration combConfig = new CombinedConfiguration();
		String propFile = StringUtils.join(env.getProperty("environment.name"), "/", props.getProperty("api.properties"));
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration> (
				PropertiesConfiguration.class).configure(params.fileBased().setListDelimiterHandler(new DefaultListDelimiterHandler(','))
						.setURL(getClass().getClassLoader().getResource(propFile)));
		
		try {
			combConfig.addConfiguration(builder.getConfiguration());
			Set<Entry<Object, Object>> propsSet = props.entrySet();
			for (Entry<Object, Object> propSet: propsSet ) {
				combConfig.addProperty((String) propSet.getKey(), propSet.getValue());
			}
		} catch (ConfigurationException ex ) {
			//todo
		}
		return combConfig;
		
	}

	
}
