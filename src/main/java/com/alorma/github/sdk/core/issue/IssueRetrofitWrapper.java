package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import com.alorma.github.sdk.core.issue.datasource.IssueService;
import retrofit2.Retrofit;

public class IssueRetrofitWrapper extends RetrofitWrapper {
  public IssueRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected IssueService get(Retrofit retrofit) {
    return retrofit.create(IssueService.class);
  }
}
