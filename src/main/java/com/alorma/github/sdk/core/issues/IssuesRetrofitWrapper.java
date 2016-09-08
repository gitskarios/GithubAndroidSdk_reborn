package com.alorma.github.sdk.core.issues;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import com.alorma.github.sdk.core.issue.IssuesSearchService;
import retrofit2.Retrofit;

public class IssuesRetrofitWrapper extends RetrofitWrapper {
  public IssuesRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected IssuesSearchService get(Retrofit retrofit) {
    return retrofit.create(IssuesSearchService.class);
  }
}
