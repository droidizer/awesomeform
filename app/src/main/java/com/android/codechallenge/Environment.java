package com.android.codechallenge;

/**
 * Created by greymatter on 14/03/16.
 */
public enum Environment {

    Development("https://api.myjson.com");

    public static Environment active = Development;

    public final String baseUrl;

    Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
