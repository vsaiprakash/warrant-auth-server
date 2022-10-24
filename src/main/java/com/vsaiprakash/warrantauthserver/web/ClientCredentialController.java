package com.vukkumsp.warrantauthserver.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.vukkumsp.warrantauthserver.model.responsemodels.ClientCredentialResponse;
import com.vukkumsp.warrantauthserver.services.ClientCredentialFlowService;

@RestController
@RequestMapping("/v1/oauth")
public class ClientCredentialController {

	@Autowired
	ClientCredentialFlowService ccfService;

    @GetMapping(value="/clientCredentialDummy")
	public String dummy(){
		System.out.println("ClientCredential Dummy endpoint called");
		return "ClientCredential Dummy";
	}

	// https://auth0.com/docs/api/authentication?http#client-credentials-flow
	// https://www.oauth.com/oauth2-servers/access-tokens/client-credentials/ 
    @PostMapping(value = "/token",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientCredentialResponse tokenRequest(
		@RequestParam String grant_type,
		@RequestParam String client_id,
		@RequestParam String client_secret,
		@RequestParam String audience,
		@RequestParam (required = false) String scope
	) {

		/*
			Reference: https://auth0.com/docs/api/authentication?http#client-credentials-flow

			HTTP/1.1 200 OK
			Content-Type: application/json
			{
				"access_token":"eyJz93a...k4laUWw",
				"token_type":"Bearer",
				"expires_in":86400
			}
		*/
		String[] scopes = null;
		if(scope==null) {
			scopes = new String[0];
		}
		else {
			scopes = scope.trim().split(" ");
		}

		return ccfService.processFlow(client_id, client_secret, audience, scopes);
	}
}