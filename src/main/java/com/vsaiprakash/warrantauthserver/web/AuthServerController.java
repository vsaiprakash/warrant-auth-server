package com.vukkumsp.warrantauthserver.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.view.RedirectView;

import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.vukkumsp.warrantauthserver.model.responsemodels.ClientCredentialResponse;
import com.vukkumsp.warrantauthserver.services.ClientCredentialFlowService;

@RestController
@RequestMapping("/v1/oauth")
public class AuthServerController {

	@Autowired
	ClientCredentialFlowService ccfService;

	@GetMapping(value="/dummy")
	public String dummy(){
		
		System.out.println("Dummy called");
		
		return "Dummy response";
	}
    
    /*
		https://auth0.com/docs/authorization/protocols/protocol-oauth2
		https://www.oauth.com/oauth2-servers/authorization/the-authorization-request/
		Supported OAuth2 Flows:-
		=========================
        ● Authorization Code Flow
        ● Client Credentials Flow
    */

	@GetMapping(value = "/authorize",
				produces = MediaType.APPLICATION_JSON_VALUE)
	public RedirectView authorize(
		@RequestParam String response_type,
		@RequestParam (required = false) String response_mode,
		@RequestParam String client_id,
		@RequestParam String redirect_uri,
		@RequestParam String scope,
		@RequestParam String state) {

		// response_type=code
		// &client_id=29352735982374239857
		// &redirect_uri=https://example-app.com/callback
		// &scope=create+delete
		// &state=xcoivjuywkdkhvusuye3kch

		// return redirect_uri+"?code="+response_type+"&state="+state;
		// return UriComponentsBuilder.fromUriString(redirect_uri)
		// 							.queryParam("code", response_type)
		// 							.queryParam("state", state)
		// 							.build()
		// 							.toUri()
		// 							.toString();

		// check if user already logged in

        // if not logged, redirect to /login page and get creds
		// if(false)
		// 	return new RedirectView("/login");

        // once logged in redirect to authorize app url

        // once user authorizes the app, it will redirect to app reduirect/callback url that is registered with auth-server app ...
        //   ... with authorization code
        //   ... https://dropletbook.com/callback?code=AUTHORIZATION_CODE

        // the client app need to request access token using the authorization code it received in previous step
        //   ... https://cloud.digitalocean.com/v1/oauth/token?client_id=CLIENT_ID&client_secret=CLIENT_SECRET&grant_type=authorization_code&code=AUTHORIZATION_CODE&redirect_uri=CALLBACK_URL

        // the token endpoint will send response like below
        /*
         *  { 
         *      "access_token":"ACCESS_TOKEN","token_type":"bearer","expires_in":2592000,
         *      "refresh_token":"REFRESH_TOKEN","scope":"read","uid":100101,
         *      "info":{"name":"Mark E. Mark","email":"mark@thefunkybunch.com"}
         *  }
         */
		redirect_uri = "https://dropletbook.com/callback";

		return new RedirectView(UriComponentsBuilder.fromUriString(redirect_uri)
		.queryParam("code", response_type)
		.queryParam("state", state)
		.build()
		.toUri()
		.toString());
									
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