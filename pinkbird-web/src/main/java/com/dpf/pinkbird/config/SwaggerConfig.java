package com.dpf.pinkbird.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {

        // 扫描指定接口所在路径
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dpf.pinkbird.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    // swagger 信息
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("利用swagger2构建的API文档")
            .description("用restful风格写接口")
            .termsOfServiceUrl("https://www.pinkbird.com/")
            .version("1.0")
            .build();
    }

}