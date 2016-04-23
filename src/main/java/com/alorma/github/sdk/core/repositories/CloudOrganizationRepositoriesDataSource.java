package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkItem;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;

public class CloudOrganizationRepositoriesDataSource extends CloudDataSource<String, List<Repo>> {

  private String sortOrder;

  public CloudOrganizationRepositoriesDataSource(RestWrapper restWrapper, String sortOrder) {
    super(restWrapper);
    this.sortOrder = sortOrder;
  }

  @Override
  protected Observable<SdkItem<List<Repo>>> execute(final SdkItem<String> data,
      final RestWrapper service) {
    return Observable.fromCallable(new Callable<SdkItem<List<Repo>>>() {
      @Override
      public SdkItem<List<Repo>> call() throws Exception {
        ReposService reposService = service.get();
        Call<List<Repo>> call;
        if (data.getPage() != null) {
          call = reposService.orgsReposList(data.getK(), data.getPage(), sortOrder);
        } else {
          call = reposService.orgsReposList(data.getK(), sortOrder);
        }

        Response<List<Repo>> listResponse = call.execute();
        Integer page = null;
        if (service.isPaginated(listResponse)) {
          page = service.getPage(listResponse);
        }

        return new SdkItem<>(page, listResponse.body());
      }
    });
  }
}
