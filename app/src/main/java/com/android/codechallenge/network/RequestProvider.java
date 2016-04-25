package com.android.codechallenge.network;

import android.support.annotation.NonNull;
import com.android.codechallenge.Environment;
import com.android.codechallenge.R;
import com.android.codechallenge.model.PersonalInfoForm;
import com.android.codechallenge.model.UserInfo;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ICallback;
import com.orhanobut.wasp.*;
import com.orhanobut.wasp.utils.NetworkMode;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import java.net.CookiePolicy;
import java.util.List;

import static com.common.android.utils.ContextHelper.getContext;
import static de.keyboardsurfer.android.widget.crouton.Crouton.makeText;

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

    private static NetworkService createNetworkService(final RemoteRequestInterceptor interceptor) {
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

    public static WaspRequest userInfo(@NonNull final ICallback<List<UserInfo>> callback) {
        return networkService().userInfo(new Callback<List<UserInfo>>() {

            @Override
            public void onSuccess(Response response, List<UserInfo> usersList) {
                callback.onSuccess(usersList);
            }

            @Override
            public void onError(WaspError waspError) {
                makeText(ContextHelper.getContext(), R.string.error, Style.ALERT).show();
            }
        });
    }

    public static WaspRequest updateInfo(@NonNull final UserInfo userInfo, @NonNull final ICallback<UserInfo> callback) {
        return networkService().updateInfo(userInfo, new Callback<UserInfo>() {
            @Override
            public void onSuccess(Response response, UserInfo userInfo) {
                callback.onSuccess(userInfo);
            }

            @Override
            public void onError(WaspError waspError) {
                makeText(ContextHelper.getContext(), R.string.error, Style.ALERT).show();

            }
        });
    }

    public static WaspRequest formConstraints(@NonNull final ICallback<PersonalInfoForm> callback) {
        return networkService().formConstraints(new Callback<PersonalInfoForm>() {
            @Override
            public void onSuccess(Response response, PersonalInfoForm formValidationData) {
                callback.onSuccess(formValidationData);
            }

            @Override
            public void onError(WaspError waspError) {
                makeText(ContextHelper.getContext(), R.string.error, Style.ALERT).show();
            }
        });
    }
}
