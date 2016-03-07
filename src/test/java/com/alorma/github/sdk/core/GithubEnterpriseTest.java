package com.alorma.github.sdk.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GithubEnterpriseTest {

    private static final String NULL_HOSTNAME = null;
    private static final String EMPTY_HOSTNAME = "";
    private static final String HOSTNAME = "https://alorma.github.io";
    private static final String HOSTNAME_HTTP = "http://alorma.github.io";
    private static final String HOSTNAME_NO_SCHEME = "alorma.github.io";
    private static final String HOSTNAME_SLASH = "https://alorma.github.io/";
    private static final String API_ENDPOINT = "https://alorma.github.io/api/v3";
    private static final String TYPE = "github-enterprise";

    @Test(expected = NullPointerException.class)
    public void ShouldThrowException_withNullUrl() {
        try {
            new GithubEnterprise(NULL_HOSTNAME);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowException_withEmptyUrl() {
        try {
            new GithubEnterprise(EMPTY_HOSTNAME);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Test
    public void ShouldReturnOauthEndpoint() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME);
        String endpoint = apiClient.getApiOauthUrlEndpoint();

        assertThat(endpoint).isEqualTo(HOSTNAME);
    }

    @Test
    public void ShouldReturnOauthEndpoint_withoutSecureScheme() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME_HTTP);
        String endpoint = apiClient.getApiOauthUrlEndpoint();

        assertThat(endpoint).isEqualTo(HOSTNAME);
    }

    @Test
    public void ShouldReturnOauthEndpoint_withoutScheme() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME_NO_SCHEME);
        String endpoint = apiClient.getApiOauthUrlEndpoint();

        assertThat(endpoint).isEqualTo(HOSTNAME);
    }

    @Test
    public void ShouldReturnApiEndpoint() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME);
        String endpoint = apiClient.getApiEndpoint();

        assertThat(endpoint).isEqualTo(API_ENDPOINT);
    }

    @Test
    public void ShouldReturnApiEndpoint_withSlash() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME_SLASH);
        String endpoint = apiClient.getApiEndpoint();

        assertThat(endpoint).isEqualTo(API_ENDPOINT);
    }

    @Test
    public void ShouldReturnApiEndpoint_withoutSecureScheme() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME_HTTP);
        String endpoint = apiClient.getApiEndpoint();

        assertThat(endpoint).isEqualTo(API_ENDPOINT);
    }

    @Test
    public void ShouldReturnApiEndpoint_withoutScheme() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME_NO_SCHEME);
        String endpoint = apiClient.getApiEndpoint();

        assertThat(endpoint).isEqualTo(API_ENDPOINT);
    }

    @Test
    public void ShouldReturnType() {
        ApiClient apiClient = new GithubEnterprise(HOSTNAME);
        String endpoint = apiClient.getType();

        assertThat(endpoint).isEqualTo(TYPE);
    }

}