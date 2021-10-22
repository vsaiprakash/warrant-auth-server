package com.vsaiprakash.warrantauthserver.dao;

import org.springframework.stereotype.Service;

/*
    https://www.oauth.com/oauth2-servers/client-registration/client-id-secret/
    
    Types of Apps
        Web-server app
        Single-page app
        Native app
        Mobile app
*/

@Service
public class AppsDao {
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

    void getAppByClientIdSecret() {

    }

    public boolean registerApp(
        String appName,
        String appHomeUrl,
        String appDescription,
        String appPrivacyPolicyLink,
        String[] redirectUrls
    ) {
        /*
            Application name
            An icon for the application
            URL to the application’s home page
            A short description of the application
            A link to the application’s privacy policy
            A list of redirect URLs
        */

        return false;
    }
}
