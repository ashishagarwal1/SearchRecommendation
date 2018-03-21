package com.agarwal.ashish.search.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ashishaggarwal on 06/03/18.
 */

public class SearchData {

    private String login;

    private String id;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "login:" + login + " id:" + id + " avatarUrl" + avatarUrl + "\n";
    }

}
