package com.android.codechallenge.network;

import com.orhanobut.wasp.utils.AuthToken;
import com.orhanobut.wasp.utils.RequestInterceptor;
import com.orhanobut.wasp.utils.WaspRetryPolicy;

import java.util.Map;

/**
 * Created by greymatter on 14/03/16.
 */
public class BitcoinRequestInterceptor implements RequestInterceptor {
    @Override
    public void onHeadersAdded(Map<String, String> map) {

    }

    @Override
    public void onQueryParamsAdded(Map<String, Object> map) {

    }

    @Override
    public WaspRetryPolicy getRetryPolicy() {
        return new WaspRetryPolicy(3000, 2, 1.5f);
    }

    @Override
    public AuthToken getAuthToken() {
        return null;
    }
}
