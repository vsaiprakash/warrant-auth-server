package com.vsaiprakash.warrantauthserver.model.responsemodels;

public class ClientCredentialResponse {

    public String access_token;
    public String token_type;
    public int expires_in;

    public ClientCredentialResponse(
        String access_token,
        String token_type,
        int expires_in
    ) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    //      {
        //     "access_token":"eyJz93a...k4laUWw",
        //     "token_type":"Bearer",
        //     "expires_in":86400
    //     }
}
