package com.android.codechallenge.network;

import android.widget.Toast;
import com.android.codechallenge.model.BitcoinResponseModel;
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
        final BitcoinResponseModel error = BitcoinResponseModel.from(waspError);
        showError(error);
    }

    public static void showError(BitcoinResponseModel error) {
        Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
    }

    public static void showError(WaspError waspError) {
        final BitcoinResponseModel error = BitcoinResponseModel.from(waspError);
        showError(error);
    }
}

