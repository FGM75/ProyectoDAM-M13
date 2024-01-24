package proyect.Configuracion;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfiguracionOpenApi {

    private Security crearEsquemaBearer() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Empresas y Ofertas")
                        .description("API REST para empresas y ofertas")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación Wiki")
                        .url("https://www.example.com/"))
                .addSecurityItem(new SecurityRequirement().addList("Autenticación Bearer"))
                .components(new Components().addSecuritySchemes("Autenticación Bearer", crearEsquemaBearer()));
    }
}
