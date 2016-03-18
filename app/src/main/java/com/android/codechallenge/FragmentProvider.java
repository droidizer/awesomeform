package com.android.codechallenge;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.android.codechallenge.ui.BaseFragment;
import com.android.codechallenge.ui.user.UserFormFragment;
import com.android.codechallenge.ui.user.UsersFragment;

import static com.common.android.utils.ContextHelper.getContext;
import static com.common.android.utils.extensions.FragmentExtensions.newInstance;

/**
 * Created by greymatter on 14/03/16.
 */
public class FragmentProvider {

    public static void showUsersFragment() {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        final BaseFragment fragment = newInstance(UsersFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }

    public static void showUserFormFragment() {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        final BaseFragment fragment = newInstance(UserFormFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }
}
