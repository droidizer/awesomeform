package com.android.codechallenge.network;

import android.support.annotation.NonNull;
import com.android.codechallenge.Environment;
import com.android.codechallenge.model.BitcoinResponseModel;
import com.android.codechallenge.model.DataPoint;
import com.common.android.utils.interfaces.ICallback;
import com.orhanobut.wasp.*;
import com.orhanobut.wasp.utils.NetworkMode;

import java.net.CookiePolicy;
import java.util.List;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by greymatter on 14/03/16.
 */
public class RequestProvider {

    private static final boolean MOCK_NETWORK = false;
    private static final String TAG = RequestProvider.class.getSimpleName();

    private static BitcoinService bitcoinService;

    @NonNull
    private static BitcoinRequestInterceptor createBitcoinRequestInterceptor() {
        return new BitcoinRequestInterceptor();
    }

    private static BitcoinService bitcoinService() {
        if (bitcoinService == null)
            bitcoinService = createBitcoinService(createBitcoinRequestInterceptor());
        return bitcoinService;
    }

    private static BitcoinService createBitcoinService(BitcoinRequestInterceptor interceptor) {
        return new Wasp.Builder(getContext())
                .setEndpoint(Environment.active.baseUrl)
                .setNetworkMode(MOCK_NETWORK
                        ? NetworkMode.MOCK
                        : NetworkMode.LIVE)
                .enableCookies(CookiePolicy.ACCEPT_ALL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(BitcoinService.class);
    }

    public static WaspRequest get30days(final ICallback<List<DataPoint>> callback){
        return bitcoinService().get30days(new Callback<BitcoinResponseModel>() {
            @Override
            public void onSuccess(Response response, BitcoinResponseModel bitcoinResponseModel) {
                callback.onSuccess(bitcoinResponseModel.values);
            }

            @Override
            public void onError(WaspError waspError) {

            }
        });
}}
