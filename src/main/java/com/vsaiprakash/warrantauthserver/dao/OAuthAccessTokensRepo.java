package com.vukkumsp.warrantauthserver.dao;

// import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import com.vukkumsp.warrantauthserver.model.dbmodels.OAuthClient;

/*
    https://www.oauth.com/oauth2-servers/client-registration/client-id-secret/
    
    Types of Apps
        Web-server app
        Single-page app
        Native app
        Mobile app
*/

public interface OAuthAccessTokensRepo extends CrudRepository<OAuthClient, String> {

  List<OAuthClient> findByScope(String scope);

  Optional<OAuthClient> findById(String id);

  OAuthClient findByClientId(String clientId);
}
