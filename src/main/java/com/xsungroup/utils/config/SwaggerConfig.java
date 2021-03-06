package com.xsungroup.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Chenman
 * @Description  swagger2 配置文件
 * @Date 20:03 2019/4/8
 * @Param
 * @return
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        // 自行修改为自己的包路径
        .apis(RequestHandlerSelectors.basePackage("com.xsungroup.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("api文档")
        .description("restfun 风格接口")
        //服务条款网址
        .termsOfServiceUrl("http://10.10.10.197/")
        .version("1.0.0")
//        .contact(new Contact("帅呆了", "url", "email"))
        .build();
  }
}
