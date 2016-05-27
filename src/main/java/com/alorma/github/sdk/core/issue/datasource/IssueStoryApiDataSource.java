package com.alorma.github.sdk.core.issue.datasource;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkItem;
import com.alorma.github.sdk.core.issue.Issue;
import com.alorma.github.sdk.core.issue.IssueInfo;
import com.alorma.github.sdk.core.issue.IssueStory;
import java.util.concurrent.Callable;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;

public class IssueStoryApiDataSource extends CloudDataSource<IssueInfo, IssueStory> {
  public IssueStoryApiDataSource(RestWrapper restWrapper) {
    super(restWrapper);
  }

  @Override
  protected Observable<SdkItem<IssueStory>> execute(final SdkItem<IssueInfo> request, final RestWrapper service) {
    return Observable.fromCallable(new Callable<SdkItem<IssueStory>>() {
      @Override
      public SdkItem<IssueStory> call() throws Exception {
        IssueService issueService = service.get();
        IssueInfo info = request.getK();
        Call<Issue> call = issueService.detail(info.repoInfo.owner, info.repoInfo.name, info.num);

        Response<Issue> issueResponse = call.execute();
        if (issueResponse.isSuccessful()) {

        }

        Issue issue = issueResponse.body();

        IssueStory story = new IssueStory();
        story.item = issue;

        return new SdkItem<>(Integer.MIN_VALUE, story);
      }
    });
  }
}
