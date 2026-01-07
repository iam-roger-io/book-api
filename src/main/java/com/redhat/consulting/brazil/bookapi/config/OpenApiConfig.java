package com.redhat.consulting.brazil.bookapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI bookApiOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Book API")
            .description("API REST para cadastro e gerenciamento de livros")
            .version("v1")
            .contact(new Contact()
                .name("Red Hat Consulting Brazil")
                .url("https://www.redhat.com"))
            .license(new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0")));
  }
}
