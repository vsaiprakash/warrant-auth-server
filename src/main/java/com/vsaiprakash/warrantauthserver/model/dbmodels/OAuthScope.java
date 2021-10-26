package com.vsaiprakash.warrantauthserver.model.dbmodels;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="OAUTH_SCOPES")
public class OAuthScope {
    
    @Id
    @Column(name="SCOPE")
    private String scope;
    @Column(name="IS_DEFAULT")
    private boolean isDefault;

    protected OAuthScope() {}

    public OAuthScope(
        String scope,
        boolean isDefault
    ){
        this.scope = scope;
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
      return String.format(
          "OAuthClient[SCOPE='%s', IS_DEFAULT='%s']",
          scope, isDefault);
    }
}
