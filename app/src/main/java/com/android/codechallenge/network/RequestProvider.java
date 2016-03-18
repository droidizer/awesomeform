package com.android.codechallenge.network;

import android.support.annotation.NonNull;
import com.android.codechallenge.Environment;
import com.android.codechallenge.model.PersonalInfoForm;
import com.android.codechallenge.model.UserInfo;
import com.common.android.utils.interfaces.ICallback;
import com.orhanobut.wasp.*;
import com.orhanobut.wasp.utils.NetworkMode;

import java.net.CookiePolicy;
import java.util.List;

import static com.common.android.utils.ContextHelper.getContext;

public class RequestProvider {

    private static final boolean MOCK_NETWORK = false;
    private static final String TAG = RequestProvider.class.getSimpleName();

    private static NetworkService service;

    @NonNull
    private static RemoteRequestInterceptor createRemoteRequestInterceptor() {
        return new RemoteRequestInterceptor();
    }

    private static NetworkService networkService() {
        if (service == null)
            service = createNetworkService(createRemoteRequestInterceptor());
        return service;
    }

    private static NetworkService createNetworkService(RemoteRequestInterceptor interceptor) {
        return new Wasp.Builder(getContext())
                .setEndpoint(Environment.active.baseUrl)
                .setNetworkMode(MOCK_NETWORK
                        ? NetworkMode.MOCK
                        : NetworkMode.LIVE)
                .enableCookies(CookiePolicy.ACCEPT_ALL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(NetworkService.class);
    }

    public static WaspRequest personalInfo(final ICallback<List<UserInfo>> callback) {
        return networkService().personalInfo(new Callback<List<UserInfo>>() {

            @Override
            public void onSuccess(Response response, List<UserInfo> usersList) {
                callback.onSuccess(usersList);
            }

            @Override
            public void onError(WaspError waspError) {

            }
        });
    }

    public static WaspRequest updateInfo(final ICallback<UserInfo> callback) {
        return networkService().updateInfo(new Callback<PersonalInfoForm>() {
            @Override
            public void onSuccess(Response response, PersonalInfoForm usersList) {

            }

            @Override
            public void onError(WaspError waspError) {

            }
        });
    }
}
