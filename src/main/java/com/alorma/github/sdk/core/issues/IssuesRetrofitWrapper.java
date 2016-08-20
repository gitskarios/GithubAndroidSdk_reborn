package com.alorma.github.sdk.core.issues;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import com.alorma.github.sdk.core.issue.IssuesService;
import com.alorma.github.sdk.core.repositories.ReposService;
import retrofit2.Retrofit;

public class IssuesRetrofitWrapper extends RetrofitWrapper {
  public IssuesRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected IssuesService get(Retrofit retrofit) {
    return retrofit.create(IssuesService.class);
  }
}
