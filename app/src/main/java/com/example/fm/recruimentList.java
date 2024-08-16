package com.example.fm;

public class recruimentList {

    private String profile;
    private String title;
    private String content;
    private String aa;
    private String like;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public recruimentList() {
    }

    public recruimentList(String profile, String title, String content, String aa, String like) {
        this.profile = profile;
        this.title = title;
        this.content = content;
        this.aa = aa;
        this.like = like;
    }
}
