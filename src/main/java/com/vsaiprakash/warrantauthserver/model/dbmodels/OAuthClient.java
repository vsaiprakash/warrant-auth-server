package com.vukkumsp.warrantauthserver.model.dbmodels;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="OAUTH_CLIENTS")
public class OAuthClient {
    
    @Id
    @Column(name="CLIENT_ID")
    private String clientId;
    @Column(name="CLIENT_SECRET")
    private String clientSecret;
    @Column(name="REDIRECT_URI")
    private String redirectUri;
    @Column(name="GRANT_TYPES")
    private String grantTypes;
    @Column(name="SCOPE")
    private String scope;
    @Column(name="USER_ID")
    private String userId;

    protected OAuthClient() {}

    public OAuthClient(
        String clientId,
        String clientSecret,
        String redirectUri,
        String grantTypes,
        String scope,
        String userId
    ){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.grantTypes = grantTypes;
        this.scope = scope;
        this.userId = userId;
    }

    @Override
    public String toString() {
      return String.format(
          "OAuthClient[CLIENT_ID='%s', CLIENT_SECRET='%s', REDIRECT_URI='%s',"+
          "GRANT_TYPES='%s', SCOPE='%s', USER_ID='%s']",
          clientId, clientSecret, redirectUri, grantTypes, scope, userId);
    }
}
