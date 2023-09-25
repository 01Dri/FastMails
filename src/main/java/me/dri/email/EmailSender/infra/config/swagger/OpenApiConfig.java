package me.dri.email.EmailSender.infra.config.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                .title("FastMails")
                .version("0.1")
                .description("Uma API para envio de emails de maneira simples e rápida")
                .termsOfService("")
                .license(new License().name("Diego").url("https://github.com/01Dri")));
    }
}
