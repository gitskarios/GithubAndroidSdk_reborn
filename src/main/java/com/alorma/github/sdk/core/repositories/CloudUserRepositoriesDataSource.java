package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkResponse;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;

public class CloudUserRepositoriesDataSource extends CloudDataSource<String, List<Repo>> {

  private String sortOrder;

  public CloudUserRepositoriesDataSource(RestWrapper restWrapper, String sortOrder) {
    super(restWrapper);
    this.sortOrder = sortOrder;
  }

  @Override
  protected Observable<SdkResponse<List<Repo>>> execute(final String username,
      final RestWrapper service) {
    return Observable.fromCallable(new Callable<SdkResponse<List<Repo>>>() {
      @Override
      public SdkResponse<List<Repo>> call() throws Exception {
        ReposService reposService = service.get();
        Call<List<Repo>> call;
        if (username != null) {
          call = reposService.userReposList(username, sortOrder);
        } else {
          call = reposService.userReposList(sortOrder);
        }

        Response<List<Repo>> listResponse = call.execute();
        int page = 0;
        if (service.isPaginated(listResponse)) {
          page = service.getPage(listResponse);
        }

        return new SdkResponse<>(page, listResponse.body());
      }
    });
  }
}
