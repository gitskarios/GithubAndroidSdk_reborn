package com.alorma.github.sdk.core.datasource;

import rx.Observable;

public abstract class CloudDataSource<Request, Data> {

  private RestWrapper restWrapper;

  public CloudDataSource(RestWrapper restWrapper) {
    this.restWrapper = restWrapper;
  }

  public Observable<SdkResponse<Data>> execute(Request e) {
    return execute(e, restWrapper);
  }

  protected abstract Observable<SdkResponse<Data>> execute(Request request, RestWrapper service);
}
