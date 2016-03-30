package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;
import retrofit2.Retrofit;

public class NotificationsRetrofitWrapper extends RetrofitWrapper {
  public NotificationsRetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient, token);
  }

  @Override
  protected NotificationsService get(Retrofit retrofit) {
    return retrofit.create(NotificationsService.class);
  }
}
