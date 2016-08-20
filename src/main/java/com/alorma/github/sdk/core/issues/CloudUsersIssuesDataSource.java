package com.alorma.github.sdk.core.issues;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkItem;
import com.alorma.github.sdk.core.issue.IssuesService;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func0;

public class CloudUsersIssuesDataSource extends CloudDataSource<Void, List<Issue>> {

  private final String filter;

  public CloudUsersIssuesDataSource(RestWrapper restWrapper, String filter) {
    super(restWrapper);
    this.filter = filter;
  }

  @Override
  protected Observable<SdkItem<List<Issue>>> execute(final SdkItem<Void> data, final RestWrapper service) {
    return Observable.defer(new Func0<Observable<SdkItem<List<Issue>>>>() {
      @Override
      public Observable<SdkItem<List<Issue>>> call() {
        IssuesService issuesService = service.get();
        Call<List<Issue>> call;
        if (data.getPage() != null) {
          call = issuesService.userIssues(filter, data.getPage());
        } else {
          call = issuesService.userIssues(filter);
        }

        try {
          Response<List<Issue>> listResponse = call.execute();
          if (listResponse.isSuccessful()) {
            Integer page = null;
            if (service.isPaginated(listResponse)) {
              page = service.getPage(listResponse);
            }

            return Observable.just(new SdkItem<>(page, listResponse.body()));
          } else {
            return Observable.error(new Exception(listResponse.message()));
          }
        } catch (IOException e) {
          return Observable.error(e);
        }
      }
    });
  }
}
