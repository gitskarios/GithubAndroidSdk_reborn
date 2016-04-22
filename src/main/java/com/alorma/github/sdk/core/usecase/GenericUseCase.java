package com.alorma.github.sdk.core.usecase;

import com.alorma.github.sdk.core.datasource.SdkResponse;
import com.alorma.github.sdk.core.repository.GenericRepository;
import rx.Observable;

public class GenericUseCase<Request, Data> {

  GenericRepository<Request, Data> repository;

  public GenericUseCase(GenericRepository<Request, Data> repository) {
    if (repository == null) {
      throw new NullPointerException("Repository cannot be null");
    }
    this.repository = repository;
  }

  public Observable<SdkResponse<Data>> execute(Request request) {
    return repository.execute(request);
  }
}
