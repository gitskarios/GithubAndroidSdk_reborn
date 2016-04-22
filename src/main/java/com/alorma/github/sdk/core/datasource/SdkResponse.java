package com.alorma.github.sdk.core.datasource;

public class SdkResponse<K> {
  private int page;
  private K k;

  public SdkResponse(int page, K k) {
    this.page = page;
    this.k = k;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public K getK() {
    return k;
  }

  public void setK(K k) {
    this.k = k;
  }
}
