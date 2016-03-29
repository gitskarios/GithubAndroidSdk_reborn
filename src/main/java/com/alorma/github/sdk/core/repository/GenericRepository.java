package com.alorma.github.sdk.core.repository;

import com.alorma.github.sdk.core.datasource.CacheDataSource;
import com.alorma.github.sdk.core.datasource.CloudDataSource;

public class GenericRepository<Identifier, Request, Data>  {

  CacheDataSource<Identifier, Data> cache;
  CloudDataSource<Data, Request> cloud;

  public GenericRepository(CacheDataSource<Identifier, Data> cache,
      CloudDataSource<Data, Request> cloud) {
    this.cache = cache;
    this.cloud = cloud;
  }

  public Data execute(Request request, Identifier identifier) {
    Data data = null;
    if (cache != null) {
      data = cache.getData(identifier);
    }

    if (data != null) {
      return data;
    }

    if (cloud != null) {
      data = cloud.execute(request);
    }
    return data;
  }
}
