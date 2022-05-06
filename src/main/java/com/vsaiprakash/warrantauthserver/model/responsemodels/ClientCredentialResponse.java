package com.vsaiprakash.warrantauthserver.model.responsemodels;

public class ClientCredentialResponse {

    /*
		Reference: https://auth0.com/docs/api/authentication?http#client-credentials-flow

		HTTP/1.1 200 OK
		Content-Type: application/json
        {
            "access_token":"eyJz93a...k4laUWw",
            "token_type":"Bearer",
            "expires_in":86400
        }
	*/

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
}
