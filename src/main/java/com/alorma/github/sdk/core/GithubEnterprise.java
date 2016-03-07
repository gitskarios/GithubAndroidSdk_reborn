package com.alorma.github.sdk.core;

public class GithubEnterprise implements ApiClient {

    private String url;

    public GithubEnterprise(String url) {
        if (url == null) {
            throw new NullPointerException();
        }
        if (url.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (url.startsWith("http://")) {
            url = url.replace("http://", "https://");
        }
        if (!url.startsWith("https://")) {
            url = "https://" + url;
        }
        this.url = url;
    }

    @Override
    public String getApiOauthUrlEndpoint() {
        return url;
    }

    @Override
    public String getApiEndpoint() {
        String hostname = url;
        if (!hostname.endsWith("/")) {
            hostname += "/";
        }
        return hostname + "api/v3";
    }

    @Override
    public String getType() {
        return "github-enterprise";
    }
}
