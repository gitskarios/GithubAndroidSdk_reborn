package com.alorma.github.sdk.core.repository;

import com.alorma.github.sdk.core.datasource.CacheDataSource;
import com.alorma.github.sdk.core.datasource.CloudDataSource;
import java.io.IOException;

public class GenericRepository<Request, Data>  {

  CacheDataSource<Request, Data> cache;
  CloudDataSource<Request, Data> cloud;

  public GenericRepository(CacheDataSource<Request, Data> cache,
      CloudDataSource<Request, Data> cloud) {
    this.cache = cache;
    this.cloud = cloud;
  }

  public Data execute(Request request) throws IOException {
    Data data = null;
    if (cache != null) {
      data = cache.getData(request);
    }

    if (data != null) {
      return data;
    }

    if (cloud != null) {
      data = cloud.execute(request);
      if (data != null && cache != null) {
        cache.saveData(request, data);
      }
    }
    return data;
  }
}
