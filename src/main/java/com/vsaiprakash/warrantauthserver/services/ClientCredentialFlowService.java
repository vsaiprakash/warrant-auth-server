package com.vukkumsp.warrantauthserver.services;

import com.vukkumsp.warrantauthserver.model.requestmodels.TokenRequest;
import com.vukkumsp.warrantauthserver.model.responsemodels.ClientCredentialResponse;
import com.vukkumsp.warrantauthserver.model.responsemodels.TokenIntrospectionResponse;
import com.vukkumsp.warrantauthserver.dao.OAuthClientRepository;

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

        //save the generated token in db

        //enforce the token expiry somehow ? for know take it as fixed
        final int expireTime = 3600; //3600 seconds ie., 60x60 1hour

        //save the expiry timestamp in db

        return new ClientCredentialResponse(
			tokenGenerated,
			"Bearer",
			expireTime
		);
    }

    public TokenIntrospectionResponse tokenInfo(TokenRequest token){

        //validate whether token is available in database
        // if so, get its corresponding 
        //    status, scope, client_id, username, token expiry timestamp from db
        //   and return the data

        return new TokenIntrospectionResponse(
			"active",
			"scope",
			"client_id",
			"username",
			"exp"
		);
    }
}
