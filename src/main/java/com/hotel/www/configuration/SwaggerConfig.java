package com.hotel.www.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //声明该类为配置类
@EnableSwagger2 //声明启动Swagger2
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("situation")
                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
                .select().apis(RequestHandlerSelectors.basePackage("com.hotel.www.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("酒店管理系统接口")
                .description("酒店管理系统接口管理")
                .termsOfServiceUrl("/Situation/")
                .contact(new Contact("xcw", "", ""))
                .license("酒店管理系统 License")
                .licenseUrl("")
                .version("1.0")
                .build();
    }
}
