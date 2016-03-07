package com.alorma.github.sdk.core.datasource;

public interface CloudDataSource<Data, Request> {
    Data execute(Request e);
}
