package com.scm.helpers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication){

       

        // Agar email id se login kiya hai to:  email kaise nikalenge

        if(authentication instanceof OAuth2AuthenticationToken ){
            var aOAuth2AuthenticationToken= (OAuth2AuthenticationToken)authentication;
            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauthUser = (DefaultOAuth2User) authentication.getPrincipal();

            String userName="";
            if(clientId.equalsIgnoreCase("google")){
                //google se login kare to email kaise nikale
                System.out.println("Getting email from google");
                userName = oauthUser.getAttribute("email").toString();

            }
            else if(clientId.equalsIgnoreCase("github")){

                 // github se login kare to email kaise nikale
                 System.out.println("Getting email from github");
                 userName= oauthUser.getAttribute("email") != null ?
                        oauthUser.getAttribute("email").toString() : oauthUser.getAttribute("login").toString()+ "@gamil.com";
            }
            return userName;
    
        }
        else{
            System.out.println("getting email from local database");
            return authentication.getName();
        }

        

    }

}
