package com.vsaiprakash.warrantauthserver.dao;

// import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import com.vsaiprakash.warrantauthserver.model.dbmodels.OAuthClient;

/*
    https://www.oauth.com/oauth2-servers/client-registration/client-id-secret/
    
    Types of Apps
        Web-server app
        Single-page app
        Native app
        Mobile app
*/

public interface OAuthClientRepository extends CrudRepository<OAuthClient, String> {
    //Connect with DB for App details
    /*
            String appName, [no spaces, only small letters, hypens, UNIQUE in table like an ID]
            String appHomeUrl,
            String appDescription,
            String appPrivacyPolicyLink,
            String redirectUrlLink,
            Encrypted String ClientId,
            Encrypted String ClientSecret,
            String GrantTypeSupported = "client_credentials" [FIXED]
    */

    
  List<OAuthClient> findByScope(String scope);

  Optional<OAuthClient> findById(String id);

  OAuthClient findByClientId(String clientId);
}
