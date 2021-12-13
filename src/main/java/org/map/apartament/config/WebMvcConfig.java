package org.map.apartament.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.MultipartConfigElement;
import java.time.Duration;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "org.map.apartament.controller"
})
public class WebMvcConfig implements WebMvcConfigurer {

    private final String FILE_MAX_SIZE = "128KB";
    private final String RESOURCES_HANDLER = "/resources/**";
    private final String RESOURCES_LOCATIONS = "classpath:/static/";
    private final String VIEW_PREFIX = "/WEB-INF/views/";
    private final String VIEW_SUFFIX = ".jsp";
    private final Integer MAX_UPLOAD_SIZE_FILE = 524288000;
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix(VIEW_PREFIX);
        resolver.setSuffix(VIEW_SUFFIX);
        return resolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER)
                .addResourceLocations( RESOURCES_LOCATIONS)
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse(FILE_MAX_SIZE));
        factory.setMaxRequestSize(DataSize.parse(FILE_MAX_SIZE));
        return factory.createMultipartConfig();
    }
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE_FILE);
        return commonsMultipartResolver;

    }
}
