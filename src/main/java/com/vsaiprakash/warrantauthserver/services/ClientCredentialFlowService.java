package com.vsaiprakash.warrantauthserver.services;

import com.vsaiprakash.warrantauthserver.model.responsemodels.ClientCredentialResponse;
import com.vsaiprakash.warrantauthserver.dao.OAuthClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCredentialFlowService {

    @Autowired
    OAuthClientRepository appDao;

    public ClientCredentialResponse processFlow(
        String client_id, String client_secret, String audience, String[] scopes){
        
        //validate app with client id & client secret


        //generate a token and update it in DB of app scope table for ref
        final String tokenGenerated = "abc";

        //enforce the token expiry somehow ? for know take it as fixed
        final int expireTime = 3600; //3600 seconds ie., 60x60 1hour

        return new ClientCredentialResponse(
			tokenGenerated,
			"Bearer",
			expireTime
		);
    }
}
