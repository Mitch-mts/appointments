package mts.mtech.appointments.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Appointments Service")
                .description("API for booking appointments")
                .version("2.0")
                .contact(apiContact())
                .license(apiLicense());
    }

    private License apiLicense(){
        return new License()
                .name("MIT License")
                .url("#");
    }

    private Contact apiContact(){
        return new Contact()
                .name("MTech Innovations")
                .email("bigmitchsystems@gmail.com")
                .url("#");
    }
}
