/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursoVN.videojuegos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Alberto
 */
//Configuracion necesaria para la interfaz de Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig  {
    
  @Bean
            public Docket api() {
                        return new Docket(DocumentationType.SWAGGER_2)
                                    .select()
                                    .apis(
                                            RequestHandlerSelectors
                                            .basePackage("com.cursoVN.videojuegos.controller"))
                                    .paths(PathSelectors.any())
                                    .build();
                }
    
}
