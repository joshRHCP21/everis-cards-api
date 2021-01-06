package com.bank.cards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
    @Bean
    public Docket accountApi()
    {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("card-api")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/core/cards.*"))
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("Card API")
                .description("Api for Cards")
                .version("1.0")
                .build();
    }
}
