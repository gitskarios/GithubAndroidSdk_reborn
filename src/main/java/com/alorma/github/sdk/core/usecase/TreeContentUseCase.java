package com.alorma.github.sdk.core.usecase;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.SdkItem;
import com.alorma.github.sdk.core.repositories.RepoInfo;
import com.alorma.github.sdk.core.tree.TreeContent;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public class TreeContentUseCase {

  private CloudDataSource<RepoInfo, List<TreeContent>> dataSource;

  public TreeContentUseCase(CloudDataSource<RepoInfo, List<TreeContent>> dataSource) {
    this.dataSource = dataSource;
  }

  public Observable<List<TreeContent>> getTree(RepoInfo repoInfo) {
    return dataSource.execute(new SdkItem<>(repoInfo)).map(new Func1<SdkItem<List<TreeContent>>, List<TreeContent>>() {
      @Override
      public List<TreeContent> call(SdkItem<List<TreeContent>> listSdkItem) {
        return listSdkItem.getK();
      }
    });
  }
}
