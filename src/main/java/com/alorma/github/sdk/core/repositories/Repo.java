package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.User;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class Repo extends ShaUrl {

  public boolean fork;
  @SerializedName("private") public boolean isPrivate;
  public Date created_at;
  public Date pushed_at;
  public Date updated_at;
  public int forks_count;
  public long id;
  public Repo parent;
  public Repo source;
  public String clone_url;
  public String description;
  public String homepage;
  public String git_url;
  public String language;
  public String default_branch;
  public String mirror_url;
  public String name;
  @SerializedName("full_name")
  public String fullName;
  public String ssh_url;
  public String svn_url;
  public User owner;
  public int stargazers_count;
  public int subscribers_count;
  public int network_count;
  public int watchers_count;
  public int size;
  public int open_issues_count;
  public boolean has_issues;
  public boolean has_downloads;
  public boolean has_wiki;
  public Permissions permissions;
  public License license;
  public List<Branch> branches;
  public String archive_url;

  public Repo() {
    super();
  }

  public String getMirror_url() {
    return mirror_url;
  }

  public void setMirror_url(String mirror_url) {
    this.mirror_url = mirror_url;
  }

  public boolean isFork() {
    return fork;
  }

  public void setFork(boolean fork) {
    this.fork = fork;
  }

  public boolean isPrivate() {
    return isPrivate;
  }

  public void setPrivate(boolean aPrivate) {
    isPrivate = aPrivate;
  }

  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

  public Date getPushed_at() {
    return pushed_at;
  }

  public void setPushed_at(Date pushed_at) {
    this.pushed_at = pushed_at;
  }

  public Date getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(Date updated_at) {
    this.updated_at = updated_at;
  }

  public int getForks_count() {
    return forks_count;
  }

  public void setForks_count(int forks_count) {
    this.forks_count = forks_count;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Repo getParent() {
    return parent;
  }

  public void setParent(Repo parent) {
    this.parent = parent;
  }

  public Repo getSource() {
    return source;
  }

  public void setSource(Repo source) {
    this.source = source;
  }

  public String getClone_url() {
    return clone_url;
  }

  public void setClone_url(String clone_url) {
    this.clone_url = clone_url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getGit_url() {
    return git_url;
  }

  public void setGit_url(String git_url) {
    this.git_url = git_url;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getDefault_branch() {
    return default_branch;
  }

  public void setDefault_branch(String default_branch) {
    this.default_branch = default_branch;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getSsh_url() {
    return ssh_url;
  }

  public void setSsh_url(String ssh_url) {
    this.ssh_url = ssh_url;
  }

  public String getSvn_url() {
    return svn_url;
  }

  public void setSvn_url(String svn_url) {
    this.svn_url = svn_url;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public int getStargazers_count() {
    return stargazers_count;
  }

  public void setStargazers_count(int stargazers_count) {
    this.stargazers_count = stargazers_count;
  }

  public int getSubscribers_count() {
    return subscribers_count;
  }

  public void setSubscribers_count(int subscribers_count) {
    this.subscribers_count = subscribers_count;
  }

  public int getNetwork_count() {
    return network_count;
  }

  public void setNetwork_count(int network_count) {
    this.network_count = network_count;
  }

  public int getWatchers_count() {
    return watchers_count;
  }

  public void setWatchers_count(int watchers_count) {
    this.watchers_count = watchers_count;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getOpen_issues_count() {
    return open_issues_count;
  }

  public void setOpen_issues_count(int open_issues_count) {
    this.open_issues_count = open_issues_count;
  }

  public boolean isHas_issues() {
    return has_issues;
  }

  public void setHas_issues(boolean has_issues) {
    this.has_issues = has_issues;
  }

  public boolean isHas_downloads() {
    return has_downloads;
  }

  public void setHas_downloads(boolean has_downloads) {
    this.has_downloads = has_downloads;
  }

  public boolean isHas_wiki() {
    return has_wiki;
  }

  public void setHas_wiki(boolean has_wiki) {
    this.has_wiki = has_wiki;
  }

  public Permissions getPermissions() {
    return permissions;
  }

  public void setPermissions(Permissions permissions) {
    this.permissions = permissions;
  }

  public License getLicense() {
    return license;
  }

  public void setLicense(License license) {
    this.license = license;
  }

  public List<Branch> getBranches() {
    return branches;
  }

  public void setBranches(List<Branch> branches) {
    this.branches = branches;
  }

  public String getArchive_url() {
    return archive_url;
  }

  public void setArchive_url(String archive_url) {
    this.archive_url = archive_url;
  }
}