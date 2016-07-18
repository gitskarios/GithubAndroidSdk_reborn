package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import retrofit2.Retrofit;

public class IssuesRetrofitWrapper extends RetrofitWrapper {
  public IssuesRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected IssueCommentsRetrofit get(Retrofit retrofit) {
    return retrofit.create(IssueCommentsRetrofit.class);
  }
}
