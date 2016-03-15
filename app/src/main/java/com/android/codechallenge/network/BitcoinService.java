package com.android.codechallenge.network;

import com.android.codechallenge.model.BitcoinResponseModel;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.GET;

/**
 * Created by greymatter on 14/03/16.
 */
public interface BitcoinService {

    // Async call
    @GET("/bins/2ivwr")
    WaspRequest get30days(Callback<BitcoinResponseModel> callback);
}
