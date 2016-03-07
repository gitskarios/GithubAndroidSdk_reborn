package com.alorma.github.sdk.core.datasource;

public interface CacheDataSource<Identifier, Data> {

    void saveData(Identifier identifier, Data data);

    Data getData(Identifier identifier);

}
