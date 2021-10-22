package com.vsaiprakash.warrantauthserver.web;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
public class AuthServerController {
    
    // ------ Basic Controller -----------

	@GetMapping("/")
	public String root(Model model) {
		return "redirect:/index";
	}

	// this will cause Circular reference exception
	@GetMapping("/index")
	public String index(Model model) {
		return "intro"; //using intro instead of index to avoid circular ref exception
	}

    /*
		Supported OAuth2 Flows:-
		=========================
        ● Authorization Code Flow
        ● Client Credentials Flow
    */

    // ------------------ Plain Auth Code Flow for User Login -----------------

	@GetMapping(value = "/authorize", params = "grant_type=authorization_code")
	public String authorizationCodeGrant(Model model) {

		model.addAttribute("message", "Auth Code Flow");

		return "authorize";
	}

    @PostMapping(value = "/oauth/token", params = "grant_type=authorization_code")
	public String tokenRequest() {

		return "token response for authorization code flow";
	}

    // ------------------ Plain Client Credentials Flow ------------------------

	// @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
	// public String clientCredentialsGrant() {

	// 	return "token response for client credentials flow";
	// }

	@PostMapping(value = "/oauth/token")
	public String tokenRequest(Model model) {

		System.out.println("post /oauth/token called");
		return "token creds";
	}


}