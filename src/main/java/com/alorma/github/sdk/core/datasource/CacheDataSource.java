package com.alorma.github.sdk.core.datasource;

import rx.Observable;

public interface CacheDataSource<Request, Data> {

  void saveData(Request request, Data data);

  Observable<SdkResponse<Data>> getData(Request request);
}
