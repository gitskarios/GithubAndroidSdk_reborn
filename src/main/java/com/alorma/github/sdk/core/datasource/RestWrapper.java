package com.alorma.github.sdk.core.datasource;

import com.alorma.github.sdk.core.ApiClient;

public abstract class RestWrapper {

  private ApiClient apiClient;

  public RestWrapper(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public <T> T get() {
    return get(apiClient);
  }

  protected abstract <T> T get(ApiClient apiClient);
}
