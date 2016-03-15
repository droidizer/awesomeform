package com.android.codechallenge.network;

import android.support.annotation.NonNull;

/**
 * Created by greymatter on 14/03/16.
 */
public interface Command<T> {

    void execute(@NonNull final T t);
}
