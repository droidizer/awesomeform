package com.android.codechallenge.model;

import android.support.annotation.NonNull;
import com.common.android.utils.logging.Logger;
import com.orhanobut.wasp.WaspError;

import java.util.List;

import static com.common.android.utils.misc.GsonProvider.getGson;

/**
 * Created by greymatter on 14/03/16.
 */
public class BitcoinResponseModel {

    public List<DataPoint> values;

    private static final String TAG = BitcoinResponseModel.class.getSimpleName();

    @NonNull
    public synchronized static BitcoinResponseModel from(final WaspError waspError) {
        BitcoinResponseModel error = new BitcoinResponseModel();
        try {
            error = getGson().fromJson(waspError.getResponse().getBody(), BitcoinResponseModel.class);

            if (error == null)
                Logger.e(TAG, waspError.toString());

        } catch (Exception e) {
            e.printStackTrace();
            waspError.getResponse().getBody();
        } finally {
            if (error == null)
                error = new BitcoinResponseModel();
        }
        if (waspError.getResponse() != null)
            waspError.getResponse().getStatusCode();
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BitcoinResponseModel that = (BitcoinResponseModel) o;

        return values != null ? values.equals(that.values) : that.values == null;

    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BitcoinResponseModel{" +
                "values=" + values +
                '}';
    }
}
