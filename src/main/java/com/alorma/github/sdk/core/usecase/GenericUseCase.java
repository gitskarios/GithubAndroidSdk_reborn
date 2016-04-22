package com.alorma.github.sdk.core.usecase;

import com.alorma.github.sdk.core.datasource.SdkItem;
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

  public Observable<SdkItem<Data>> execute(SdkItem<Request> request) {
    return repository.execute(request);
  }
}
