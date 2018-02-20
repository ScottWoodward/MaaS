package com.binaryphoenixstudios.maas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addRedirectViewController("/api/documentation/v2/api-docs", "/v2/api-docs");
		registry.addRedirectViewController("/api/documentation/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
		registry.addRedirectViewController("/api/documentation/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
		registry.addRedirectViewController("/api/documentation/swagger-resources", "/swagger-resources");
		registry.addRedirectViewController("/api/documentation", "/documentation/swagger-ui.html");
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.
				addResourceHandler("/api/documentation/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.
				addResourceHandler("/api/documentation/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
