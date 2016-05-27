package com.alorma.github.sdk.core.issue;

import java.util.Comparator;

public class IssueStoryComparators {

  public static Comparator<IssueStoryDetail> ISSUE_STORY_DETAIL_COMPARATOR =
      new Comparator<IssueStoryDetail>() {
        @Override
        public int compare(IssueStoryDetail lhs, IssueStoryDetail rhs) {
          if (lhs.createdAt() > rhs.createdAt()) {
            return 1;
          } else if (lhs.createdAt() < rhs.createdAt()) {
            return -1;
          }
          return 0;
        }
      };

  public IssueStoryComparators() {
  }
}
