package com.android.codechallenge.network;

import com.android.codechallenge.model.PersonalInfoForm;
import com.android.codechallenge.model.UserInfo;
import com.android.codechallenge.model.UserResponseModel;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.POST;

import java.util.List;

public interface NetworkService {

    @GET("/bins/51k13")
    WaspRequest personalInfo(Callback<List<UserInfo>> callback);

    @POST("/personalinfo")
    WaspRequest updateInfo(Callback<PersonalInfoForm> callback);
}
