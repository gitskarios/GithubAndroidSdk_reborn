package com.alorma.github.sdk;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GithubTest {

    private Github github;

    @Before
    public void setUp() {
        github = new Github();
    }

    @Test
    public void ShouldReturnApiEndpoint() {
        String endpoint = github.getEndpoint();

        assertThat(endpoint).isEqualTo("http://api.github.com");
    }

}