package com.alorma.github.sdk.core.datasource;

import java.io.IOException;

public abstract class CloudDataSource<Request, Data> {

  private RestWrapper restWrapper;

  public CloudDataSource(RestWrapper restWrapper) {
    this.restWrapper = restWrapper;
  }

  public Data execute(Request e) throws IOException {
    return execute(e, restWrapper);
  }

  protected abstract Data execute(Request request, RestWrapper service) throws IOException;
}
