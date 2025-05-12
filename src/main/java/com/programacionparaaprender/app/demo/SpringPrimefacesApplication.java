package com.programacionparaaprender.app.demo;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.luv2code.jsf.jdbc", "com.programacionparaaprender.editor", "com.programacionparaaprender.app.demo", "com.programacionparaaprender.service",  
		"com.cavanosa.virtual.entity","com.cavanosa.virtual.repository","com.cavanosa.virtual.service", "com.cavanosa.virtual.service.impl"})
@EnableAutoConfiguration
public class SpringPrimefacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrimefacesApplication.class, args);
	}
	
	@Bean
	ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
	      //spring boot only works if this is set
	      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

	      //registration
	      ServletRegistrationBean srb = new ServletRegistrationBean();
	      srb.setServlet(new FacesServlet());
	      srb.setUrlMappings(Arrays.asList("*.xhtml"));
	      srb.setLoadOnStartup(1);
	      return srb;
	}

}
