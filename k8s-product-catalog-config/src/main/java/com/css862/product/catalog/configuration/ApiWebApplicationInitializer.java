package com.css862.product.catalog.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
public class ApiWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(RootConfigurations.class);
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispacher = servletContext.addServlet("CXFServlet", new CXFServlet());
		dispacher.setLoadOnStartup(1);
		dispacher.addMapping("/*");
		dispacher.setInitParameter("contextConfigLocation", "com.css862.product.catalog.configuration.RootConfigurations");
		dispacher.setInitParameter("spring.profiles.default", "default");
		
	}

	
}
