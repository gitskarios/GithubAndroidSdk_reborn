package com.alorma.github.sdk.core.repositories.releases.tags;

import com.alorma.github.sdk.core.Exclude;
import com.alorma.github.sdk.core.Sha;
import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.repositories.Commit;
import com.alorma.github.sdk.core.repositories.releases.Release;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {
    @SerializedName("name") private String name;
    @SerializedName("commit") private Sha sha;
    @SerializedName("zipball_url") private String zipballUrl;
    @SerializedName("tarball_url") private String tarballUrl;

    @Exclude public Commit commit;
    @Exclude public Release release;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sha getSha() {
        return sha;
    }

    public void setSha(Sha sha) {
        this.sha = sha;
    }

    public String getZipballUrl() {
        return zipballUrl;
    }

    public void setZipballUrl(String zipballUrl) {
        this.zipballUrl = zipballUrl;
    }

    public String getTarballUrl() {
        return tarballUrl;
    }

    public void setTarballUrl(String tarballUrl) {
        this.tarballUrl = tarballUrl;
    }
}
