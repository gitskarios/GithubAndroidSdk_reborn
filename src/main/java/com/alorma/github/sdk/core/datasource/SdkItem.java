package com.alorma.github.sdk.core.datasource;

public class SdkItem<K> {
  private int page;
  private K k;

  public SdkItem(K k) {
    this.page = Integer.MIN_VALUE;
    this.k = k;
  }

  public SdkItem(int page, K k) {
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
