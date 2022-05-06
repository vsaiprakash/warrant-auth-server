package com.vsaiprakash.warrantauthserver.data;

import com.vsaiprakash.warrantauthserver.model.dbmodels.OAuthClient;

// CREATE TABLE oauth_clients (
//   client_id             VARCHAR(80)   NOT NULL,
//   client_secret         VARCHAR(80),
//   redirect_uri          VARCHAR(2000),
//   grant_types           VARCHAR(80),
//   scope                 VARCHAR(4000),
//   user_id               VARCHAR(80),
//   PRIMARY KEY (client_id)
// );

public class authClients {

    OAuthClient[] clients = new OAuthClient[1];

    authClients() {
        this.clients[0]
             = new OAuthClient(null, null,
                                null, null,
                                null, null);
    }


    OAuthClient[] getAuthClients() {
        return null;
    }

    OAuthClient getAuthClient(String clientId, String clientSecret){
        return null;
    }
    
}
