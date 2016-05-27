package com.alorma.github.sdk.core.issue.datasource;

import com.alorma.github.sdk.core.issue.Issue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IssueService {

  @GET("/repos/{owner}/{name}/issues/{num}")
  Call<Issue> detail(@Path("owner") String owner, @Path("name") String repo, @Path("num") int num);
}
