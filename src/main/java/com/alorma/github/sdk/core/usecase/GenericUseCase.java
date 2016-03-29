package com.alorma.github.sdk.core.usecase;

import com.alorma.github.sdk.core.repository.GenericRepository;
import java.io.IOException;

public class GenericUseCase<Request, Data> {

  GenericRepository<Request, Data> repository;

  public GenericUseCase(GenericRepository<Request, Data> repository) {
    if (repository == null) {
      throw new NullPointerException("Repository cannot be null");
    }
    this.repository = repository;
  }

  public Data execute(Request request) throws IOException {
    return repository.execute(request);
  }
}
