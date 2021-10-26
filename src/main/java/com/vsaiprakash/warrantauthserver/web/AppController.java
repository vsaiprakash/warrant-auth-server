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
