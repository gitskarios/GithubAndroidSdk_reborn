package com.alorma.github.sdk.core.issues;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkItem;
import com.alorma.github.sdk.core.issue.IssuesSearchService;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func0;

public class CloudUsersIssuesDataSource extends CloudDataSource<Void, List<Issue>> {

  private final String action;
  private final String name;

  public CloudUsersIssuesDataSource(RestWrapper restWrapper, String action, String name) {
    super(restWrapper);
    this.action = action;
    this.name = name;
  }

  @Override
  protected Observable<SdkItem<List<Issue>>> execute(final SdkItem<Void> data, final RestWrapper service) {
    return Observable.defer(new Func0<Observable<SdkItem<List<Issue>>>>() {
      @Override
      public Observable<SdkItem<List<Issue>>> call() {
        String query = String.format(IssuesSearchService.QUERY, "open", action, name);
        IssuesSearchService issuesService = service.get();
        Call<IssueSearchResponse> call;
        if (data.getPage() != null) {
          call = issuesService.userIssues(query, data.getPage());
        } else {
          call = issuesService.userIssues(query);
        }

        try {
          Response<IssueSearchResponse> response = call.execute();
          if (response.isSuccessful()) {
            Integer page = null;
            if (service.isPaginated(response)) {
              page = service.getPage(response);
            }

            return Observable.just(new SdkItem<>(page, response.body().getIssues()));
          } else {
            return Observable.error(new Exception(response.message()));
          }
        } catch (IOException e) {
          return Observable.error(e);
        }
      }
    });
  }
}
