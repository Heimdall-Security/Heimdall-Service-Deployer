package com.heimdallauth.utils;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        description = "This service provides endpoints for new stacks configuration and updating existing configuration",
        title = "Heimdall Deployment Service",
        version = "1.0.0",
        license = @License(name = "GNU v3 License", url = "https://www.gnu.org/licenses/gpl-3.0.md"),
        contact = @Contact(name = "Mayank Soni", email = "heimdall-support@mayanksoni.tech")
)
)
public class ServiceDeployerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDeployerApplication.class, args);
    }

}
