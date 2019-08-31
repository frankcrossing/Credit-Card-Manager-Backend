package com.jieandata.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	@Value("${myOriginUrl}")
	private String myOriginUrl;

	/**
	 * 允许任何域名使用、允许任何头、允许任何方法（post、get等）
	 * @return
	 */
	private CorsConfiguration buildConfig(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		//addAllowedOrigin不能设置为*因为与allowCredential冲突
		// corsConfiguration.addAllowedOrigin("include");
		corsConfiguration.addAllowedOrigin(myOriginUrl);
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		//allowCredential需设置为true
		corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}
	
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource	source=new	UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",buildConfig());
		return new CorsFilter(source);
	}
}
