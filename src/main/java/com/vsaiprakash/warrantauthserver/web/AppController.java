package com.vsaiprakash.warrantauthserver.web;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.http.MediaType;

import java.util.Map;

import com.vsaiprakash.warrantauthserver.model.requestmodels.TokenRequest;
import com.vsaiprakash.warrantauthserver.model.responsemodels.ClientCredentialResponse;
import com.vsaiprakash.warrantauthserver.model.responsemodels.TokenIntrospectionResponse;
import com.vsaiprakash.warrantauthserver.services.ClientCredentialFlowService;

// import org.springframework.web.context.request.WebRequest;

@RestController
// @RequestMapping("/app")
public class AppController {
    
    //app registration endpoint
    @GetMapping("/registration")
    public ModelAndView appRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app-registration.html");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

    // https://www.digitalocean.com/community/tutorials/an-introduction-to-oauth-2
    // https://cloud.digitalocean.com/v1/oauth/authorize?response_type=code&client_id=CLIENT_ID&redirect_uri=CALLBACK_URL&scope=read
    @GetMapping("/cv")
    public RedirectView authorize(
        @RequestParam String response_type,
        @RequestParam String client_id,
        @RequestParam String redirect_uri,
        @RequestParam String scope) {

        // @RequestParam(required=false) Map<String,String> qparams
        // qparams.forEach((a,b) -> {
        //     System.out.println(String.format("%s -> %s",a,b));
        // });

        // check if user already logged in

        // if not logged, redirect to /login page and get creds

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


        return new RedirectView("/index");
    }

    @GetMapping("/index")
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

	@GetMapping("/")
    public RedirectView redirectRoot1() {
        return new RedirectView("/index");
    }

    @GetMapping("")
    public RedirectView redirectRoot2() {
        return new RedirectView("/index");
    }

    //
}
