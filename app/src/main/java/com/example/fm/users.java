package com.example.fm;

public class users {
    private String address;
    private String id;
    private String name;
    private String nickname;
    private String phonenum;
    private String uid;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public users() {
    }

    public users(String address, String id, String name, String nickname, String phonenum, String uid) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.phonenum = phonenum;
        this.uid = uid;
    }
}
