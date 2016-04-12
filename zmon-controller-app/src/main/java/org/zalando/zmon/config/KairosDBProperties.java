package org.zalando.zmon.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URL;

/**
 * FIXME: hardcoded config for Vagrant box
 *
 * @author hjacobs
 */
@ConfigurationProperties(prefix = "zmon.kairosdb")
public class KairosDBProperties {

    private URL url;

    private boolean enabled;

    private int connectTimeout = 3000; // 3 seconds
    private int socketTimeout = 30000; // 30 seconds

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * get HttpClient with appropriate timeouts
     * @return
     */
    public HttpClient getHttpClient() {
        RequestConfig config = RequestConfig.custom().setSocketTimeout(getSocketTimeout()).setConnectTimeout(getConnectTimeout()).build();
        return HttpClients.custom().setDefaultRequestConfig(config).build();
    }
}