package com.vsaiprakash.warrantauthserver.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.vsaiprakash.warrantauthserver.model.requestmodels.TokenRequest;
import com.vsaiprakash.warrantauthserver.model.responsemodels.TokenIntrospectionResponse;
import com.vsaiprakash.warrantauthserver.services.ClientCredentialFlowService;

@RestController
@RequestMapping("/v1/oauth")
public class IntrospectionController {

	@Autowired
	ClientCredentialFlowService ccfService;

	@GetMapping(value="/introspectionDummy")
	public String dummy(){
		System.out.println("Introspection Dummy endpoint called");
		return "Introspection Dummy";
	}

	// Token Introspection Endpoint
	// https://www.oauth.com/oauth2-servers/token-introspection-endpoint/
	// https://datatracker.ietf.org/doc/html/rfc7662 
	@PostMapping(value = "/token_info",
				produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
				)
	public TokenIntrospectionResponse tokenIntrospect(
		//@RequestBody won't recognize application/x-www-form-urlencoded
		TokenRequest token,
		@RequestHeader("Authorization") String bearerToken 
			//to keep endpoint secure we can use Basic auth also as long as the endpoint is kept secured
			// here for now keeping Bearer token
	) {
		/*
			POST /introspect HTTP/1.1
			Host: server.example.com
			Accept: application/json
			Content-Type: application/x-www-form-urlencoded
			Authorization: Bearer 23410913-abewfq.123483

			token=2YotnFZFEjr1zCsicMWpAA
		*/
		return ccfService.tokenInfo(token);
	}
}