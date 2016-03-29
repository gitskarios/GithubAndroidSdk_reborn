package com.alorma.github.sdk.core.usecase;

import com.alorma.github.sdk.core.repository.GenericRepository;

public class GenericUseCase<Identifier, Request, Data> {

  GenericRepository<Identifier, Request, Data> repository;

  public GenericUseCase(GenericRepository<Identifier, Request, Data> repository) {
    if (repository == null) {
      throw new NullPointerException("Repository cannot be null");
    }
    this.repository = repository;
  }

  public Data execute(Request request, Identifier identifier) {
    return repository.execute(request, identifier);
  }
}
