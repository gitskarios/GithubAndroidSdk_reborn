package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.BodyRequest;
import com.alorma.github.sdk.core.GithubComment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface IssueCommentsRetrofit {
  @PATCH("/repos/{owner}/{repo}/issues/comments/{id}")
  Call<GithubComment> editComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Body BodyRequest request);
}
