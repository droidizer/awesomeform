package com.android.codechallenge.network;

import android.widget.Toast;
import com.android.codechallenge.model.UserInfo;
import com.android.codechallenge.model.UserResponseModel;
import com.orhanobut.wasp.WaspError;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by greymatter on 14/03/16.
 */
public class Errorhandler {
    public Errorhandler() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void handleWaspError(WaspError waspError) {

    }

    public static void showError(UserInfo error) {
        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
    }

    public static void showError(WaspError waspError) {
      //  final UserData error = UserData.from(waspError);
        // showError(error);
    }
}

