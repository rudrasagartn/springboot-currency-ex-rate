package com.mywork.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Component
@EnableSwagger2
public class SwaggerComponent {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/exrate-api/.*"), regex("/exrate-api/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot API").description("SpringBoot Java API reference for developers")
				.termsOfServiceUrl("https://github.com/rudrasagartn").contact("Rudrasagar TN").license("Java License")
				.licenseUrl("https://github.com/rudrasagartn").version("1.0").build();
	}
}
