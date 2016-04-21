package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import retrofit2.Retrofit;

public class RepositoriesRetrofitWrapper extends RetrofitWrapper {
  public RepositoriesRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected ReposService get(Retrofit retrofit) {
    return retrofit.create(ReposService.class);
  }
}
