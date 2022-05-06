package com.vsaiprakash.warrantauthserver.model.responsemodels;

/*

    HTTP/1.1 200 OK
    Content-Type: application/json; charset=utf-8
    
    {
        "active": true,
        "scope": "read write email",
        "client_id": "J8NFmU4tJVgDxKaJFmXTWvaHO",
        "username": "aaronpk",
        "exp": 1437275311
    }

*/

public class TokenIntrospectionResponse {
    public String active;
    public String scope;
    public String client_id;
    public String username;
    public String exp;

    public TokenIntrospectionResponse(
        String active,
        String scope,
        String client_id,
        String username,
        String exp
    ){
        this.active = active;
        this.scope = scope;
        this.client_id = client_id;
        this.username = username;
        this.exp = exp;
    }

    /*
        HTTP/1.1 200 OK
        Content-Type: application/json; charset=utf-8
        
        {
            "active": true,
            "scope": "read write email",
            "client_id": "J8NFmU4tJVgDxKaJFmXTWvaHO",
            "username": "aaronpk",
            "exp": 1437275311
        }
    */
    
}
