package com.android.codechallenge.ui.user;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import butterknife.Bind;
import com.android.codechallenge.R;
import com.android.codechallenge.model.UserInfo;
import com.android.codechallenge.ui.BaseFragment;
import com.android.codechallenge.utils.ItemDivider;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ICallback;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.android.codechallenge.FragmentProvider.showUserFormFragment;
import static com.android.codechallenge.network.RequestProvider.userInfo;
import static com.android.codechallenge.utils.FabUtils.createFloatingActionButton;


public class UsersFragment extends BaseFragment {

    @NonNull
    @Bind(R.id.users_list)
    RecyclerView usersList;
    @NonNull
    @Bind(R.id.floating_menu)
    FloatingActionMenu fab;

    DataBindAdapter<UserInfo> usersAdapter;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

        fab.removeAllMenuButtons();
        fab.addMenuButton(createFloatingActionButton(R.string.app_name, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserFormFragment();
            }
        }));

        Crouton.makeText(ContextHelper.getContext(), R.string.saved, Style.CONFIRM);

        setupRecyclerView();

        userInfo(new ICallback<List<UserInfo>>() {
            @Override
            public void onSuccess(List<UserInfo> userInfos) {
                if (userInfos == null)
                    return;

                for (final UserInfo item : userInfos) {
                    if (isUserInfoNull(item))
                        return;

                    usersAdapter.add(item, UserDataBinder.class);
                }
            }
        });
    }

    private boolean isUserInfoNull(@NonNull final UserInfo userInfo) {
        return (userInfo.firstName == null && userInfo.gender == null && userInfo.dateOfBirth == null);
    }

    private void setupRecyclerView() {
        usersList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        usersList.addItemDecoration(new ItemDivider(ContextHelper.getContext(), R.drawable.item_divider));
        usersAdapter = new DataBindAdapter<>();
        usersList.setAdapter(usersAdapter);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_user_list;
    }

    @NotNull
    @Override
    public String tag() {
        return UsersFragment.class.getSimpleName();
    }

}
