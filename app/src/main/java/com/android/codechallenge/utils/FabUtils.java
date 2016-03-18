package com.android.codechallenge.utils;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import com.android.codechallenge.R;
import com.github.clans.fab.FloatingActionButton;
import org.jetbrains.annotations.NotNull;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by greymatter on 16/03/16.
 */

public abstract class FabUtils {
    @NotNull
    public static FloatingActionButton createFloatingActionButton(@StringRes int label, @Nullable View.OnClickListener onClickListener) {
        final FloatingActionButton button = new FloatingActionButton(getContext());
        button.setLabelText(getContext().getString(label));
        button.setColorNormalResId(R.color.dark_red);
        button.setColorPressedResId(R.color.light_red);
        button.setColorRippleResId(R.color.light_red);
        button.setOnClickListener(onClickListener);
        return button;
    }
}