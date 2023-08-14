package com.simple_payment_aot;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI myOpenAPI() {
        Info info = new Info()
                .title("Simple Payment API")
                .version("1.0.0")
                .description("This API exposes endpoints to manage payments.");

        return new OpenAPI().info(info);
    }
}
