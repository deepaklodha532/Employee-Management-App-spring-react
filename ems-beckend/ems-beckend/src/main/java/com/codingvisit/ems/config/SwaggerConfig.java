package com.codingvisit.ems.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//        name = "scheme1",
//        type= SecuritySchemeType.HTTP,
//        bearerFormat = "JWt",
//        scheme = "bearer"
//)
//@OpenAPIDefinition(
//        info = @Info(
//                title = "ElectronicStore API",
//                description = "This is backend  of  electronics  store developed  in  process courses ",
//
//                version = "1.0V",
//                contact = @Contact(
//                        name = "Deepak Lodha",
//                        email = "deepaklodha532@gmail.com"
////                        url = "http://localhost:9090"
//                ),
//
//                license = @License(
//                        name = "OPEN License"
////                        url = "http://deepakinfo.com"
//
//                )
//        ),
//        externalDocs = @ExternalDocumentation(
//                description = "",
//                url = ""
//        )
//)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
//        String schemeName = "bearerScheme" ;
//
        return new OpenAPI()
//                .addSecurityItem(
//                        new SecurityRequirement()
//                                .addList(schemeName)
//
//                )
//                .components(new Components()
//                        .addSecuritySchemes(schemeName,new SecurityScheme()
//                                .name(schemeName)
//                                .type(SecurityScheme.Type.HTTP)
//                                .bearerFormat("JWT")
//                                .scheme("bearer")
//                        )
//                )
                .info(new Info().title("ElectronicStore Api")
                        .description("This is electronic project api developed ")
                        .version("1.0")
                        .contact(new Contact().name("deepak").email("deepaklodha532@gmail.com").url("deepaklodhainfo.com"))
                        .license(new License().name("Apache"))


                )
                .externalDocs(new ExternalDocumentation().url("deepaklodhainfo.com").description("This is external url"))   ;
    }

}
