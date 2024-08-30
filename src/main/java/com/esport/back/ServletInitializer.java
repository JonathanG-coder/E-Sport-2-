package com.esport.back;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Classe pour initialiser l'application lorsque déployée dans un conteneur de
 * servlets.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configure l'application.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EsportBackApplication.class);
	}

}