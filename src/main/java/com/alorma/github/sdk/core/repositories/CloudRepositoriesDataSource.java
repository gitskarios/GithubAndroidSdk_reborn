package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;

public class CloudRepositoriesDataSource extends CloudDataSource<String, List<Repo>> {

  private String sortOrder;

  public CloudRepositoriesDataSource(RestWrapper restWrapper, String sortOrder) {
    super(restWrapper);
    this.sortOrder = sortOrder;
  }

  @Override
  protected List<Repo> execute(String username, RestWrapper service) throws IOException {
    if (username != null) {
      Call<List<com.alorma.github.sdk.core.repositories.Repo>> call =
          service.<ReposService>get().userReposList(username, sortOrder);

      return call.execute().body();
    } else {
      Call<List<com.alorma.github.sdk.core.repositories.Repo>> call =
          service.<ReposService>get().userReposList(sortOrder);

      return call.execute().body();
    }
  }
}
