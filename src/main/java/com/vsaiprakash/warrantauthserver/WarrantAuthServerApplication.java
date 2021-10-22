package com.vsaiprakash.warrantauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

//To override http url with https url as server
@OpenAPIDefinition( 
    servers = {
       @Server(url = "/", description = "Default Server URL")
    }
) 

@SpringBootApplication
public class WarrantAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarrantAuthServerApplication.class, args);
	}
}