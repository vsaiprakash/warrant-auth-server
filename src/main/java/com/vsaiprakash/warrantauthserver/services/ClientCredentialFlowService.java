package com.vsaiprakash.warrantauthserver.services;

import com.vsaiprakash.warrantauthserver.model.responsemodels.ClientCredentialResponse;

public class ClientCredentialFlowService {
    public static ClientCredentialResponse processFlow(String client_id, String client_secret){

        //validate app with client id & client secret

        //generate a token and update it in DB of app for ref
        final String tokenGenerated = "";

        //enforce the token expiry somehow ? for know take it as fixed
        final int expireTime = 3600; //3600 seconds ie., 60x60 1hour

        return new ClientCredentialResponse(
			tokenGenerated,
			"Bearer",
			expireTime
		);
    }
}
