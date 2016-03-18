package com.android.codechallenge.network;

import com.android.codechallenge.model.PersonalInfoForm;
import com.android.codechallenge.model.UserInfo;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.Body;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.POST;

import java.util.List;

public interface NetworkService {

    @GET("/personalinfo")
    WaspRequest userInfo(Callback<List<UserInfo>> callback);

    @POST("/personalinfo")
    WaspRequest updateInfo(@Body UserInfo userInfo, Callback<UserInfo> callback);

    @GET("/personalinfoform")
    WaspRequest formConstraints(Callback<PersonalInfoForm> callback);

}
