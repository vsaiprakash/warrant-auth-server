package com.vsaiprakash.warrantauthserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthServerController {
    
    // ------ Basic Controller -----------

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

    /*
        Authorization Code Flow
        Client Credentials Flow
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

	@GetMapping(value = "/authorize", params = "grant_type=client_credentials")
	public String clientCredentialsGrant() {

		return "token response for client credentials flow";
	}


}