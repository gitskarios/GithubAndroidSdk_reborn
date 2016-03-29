package com.alorma.github.sdk.core.datasource;

public interface CacheDataSource<Request, Data> {

    void saveData(Request request, Data data);

    Data getData(Request request);

}
