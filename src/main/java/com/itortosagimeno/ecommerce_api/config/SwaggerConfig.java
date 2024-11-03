package com.itortosagimeno.ecommerce_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce API",
                version = "1.0",
                description = """
                        API for managing an ecommerce platform. Roles required:
                        - **ADMIN**: Access to private endpoints for managing resources.
                        - **USER**: Access to public endpoints for browsing and interacting with available resources.""",
                contact = @Contact(
                        name = "Ivan Tortosa Gimeno",
                        url = "https://github.com/IvanTorGim/ecommerce-api",
                        email = "itortosagimeno@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = ""
                )
        },
        security = @SecurityRequirement(name = "Security token")
)
@SecurityScheme(
        name = "Security token",
        description = "Access token for Ecommerce API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "Bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
