package com.example.fm;

public class profile {
    static String email;
    static String time;

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        profile.time = time;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        profile.email = email;
    }

    public profile(String email) {
        this.email = email;
    }

    public profile() {
    }
}
