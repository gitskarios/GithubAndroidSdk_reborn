package com.alorma.github.sdk.core.repository;

import com.alorma.github.sdk.core.datasource.CacheDataSource;
import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.SdkResponse;
import rx.Observable;

public class GenericRepository<Request, Data> {

  CacheDataSource<Request, Data> cache;
  CloudDataSource<Request, Data> cloud;

  public GenericRepository(CacheDataSource<Request, Data> cache,
      CloudDataSource<Request, Data> cloud) {
    this.cache = cache;
    this.cloud = cloud;
  }

  public Observable<SdkResponse<Data>> execute(Request request) {
    Observable<SdkResponse<Data>> cacheObs = Observable.empty();
    Observable<SdkResponse<Data>> cloudObs = Observable.empty();
    if (cache != null) {
      cacheObs = cache.getData(request);
    }
    if (cloud != null) {
      cloudObs = cloud.execute(request);
    }
    return Observable.concat(cacheObs, cloudObs).first();
  }
}
