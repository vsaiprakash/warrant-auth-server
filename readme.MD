# Information

## Base Source Used
https://dzone.com/articles/implementing-your-own-spring-boot-oauth2-authoriza

<!-- With User Login -->
https://www.baeldung.com/spring-security-oauth-auth-server

https://www.oauth.com/oauth2-servers/authorization/

## Authorization Code Flow

Step 1:
    Client App -> Auth Server
https://authorization-server.com/auth?response_type=code
&client_id=29352735982374239857
&redirect_uri=https://example-app.com/callback
&scope=create+delete
&state=xcoivjuywkdkhvusuye3kch
&response_type=code

Step 2:
    User Logs In using /login page -> Client App's callback url (with specified state & generated auth code)
    https://www.oauth.com/oauth2-servers/authorization/the-authorization-response/

    auth code must expire immediately (as per oauth2 it is max 10 mins)

Step 3:
    Client App -> Auth Server 

POST /oauth/token HTTP/1.1
Host: authorization-server.com
 
grant_type=authorization_code
&code=xxxxxxxxxxx
&redirect_uri=https://example-app.com/redirect
&client_id=xxxxxxxxxx
&client_secret=xxxxxxxxxx

    https://www.oauth.com/oauth2-servers/access-tokens/authorization-code-request/

Step 4:
    Response from Auth Server

HTTP/1.1 200 OK
Content-Type: application/json
Cache-Control: no-store
Pragma: no-cache
 
{
  "access_token":"MTQ0NjJkZmQ5OTM2NDE1ZTZjNGZmZjI3",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"IwOGYzYTlmM2YxOTQ5MGE3YmNmMDFkNTVk",
  "scope":"create"
}

## Client Credentials Flow

Step 1:
    Client App -> Auth Server
POST /token HTTP/1.1
Host: authorization-server.com
 
grant_type=client_credentials
&client_id=xxxxxxxxxx
&client_secret=xxxxxxxxxx

Step 2:
    Auth Server -> Client App
HTTP/1.1 200 OK
Content-Type: application/json
Cache-Control: no-store
Pragma: no-cache
 
{
  "access_token":"MTQ0NjJkZmQ5OTM2NDE1ZTZjNGZmZjI3",
  "token_type":"bearer",
  "expires_in":3600,
  "refresh_token":"IwOGYzYTlmM2YxOTQ5MGE3YmNmMDFkNTVk",
  "scope":"create"
}