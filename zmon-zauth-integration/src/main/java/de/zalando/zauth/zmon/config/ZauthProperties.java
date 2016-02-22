package de.zalando.zauth.zmon.config;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URL;

/**
 * Created by hjacobs on 2/4/16.
 */
@ConfigurationProperties(
        prefix = "zmon.zauth"
)
public class ZauthProperties {


    private URL teamServiceUrl;
    private URL oauth2AccessTokenUrl;

    public URL getTeamServiceUrl() {
        return teamServiceUrl;
    }

    public void setTeamServiceUrl(URL teamServiceUrl) {
        this.teamServiceUrl = teamServiceUrl;
    }


    public URL getOauth2AccessTokenUrl() {
        return oauth2AccessTokenUrl;
    }

    public void setOauth2AccessTokenUrl(URL oauth2AccessTokenUrl) {
        this.oauth2AccessTokenUrl = oauth2AccessTokenUrl;
    }
}