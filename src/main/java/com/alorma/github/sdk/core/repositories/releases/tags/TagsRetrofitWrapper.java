package com.alorma.github.sdk.core.repositories.releases.tags;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.datasource.RetrofitWrapper;

import retrofit2.Retrofit;

public class TagsRetrofitWrapper extends RetrofitWrapper {

    public TagsRetrofitWrapper(ApiClient apiClient, String token) {
        super(apiClient, token);
    }

    @Override
    protected RepositoryTagsService get(Retrofit retrofit) {
        return retrofit.create(RepositoryTagsService.class);
    }
}
