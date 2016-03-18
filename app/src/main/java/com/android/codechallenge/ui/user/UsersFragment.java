package com.android.codechallenge.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import com.android.codechallenge.ui.BaseFragment;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.common.android.utils.ui.recyclerView.SpacesItemDecoration;
import com.github.clans.fab.FloatingActionMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import com.android.codechallenge.R;
import com.android.codechallenge.model.UserInfo;
import com.common.android.utils.interfaces.ICallback;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.android.codechallenge.FragmentProvider.showUserFormFragment;
import static com.android.codechallenge.network.RequestProvider.personalInfo;
import static com.android.codechallenge.utils.FabUtils.createFloatingActionButton;


public class UsersFragment extends BaseFragment {

    @NonNull
    @Bind(R.id.users_list)
    RecyclerView usersList;
    @NonNull
    @Bind(R.id.floating_menu)
    FloatingActionMenu floatingMenu;
    
    DataBindAdapter<UserInfo> usersAdapter;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

        floatingMenu.addMenuButton(createFloatingActionButton(R.string.app_name, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserFormFragment();
            }
        }));

        setupRecyclerView();

        personalInfo(new ICallback<List<UserInfo>>() {
            @Override
            public void onSuccess(List<UserInfo> userInfos) {
                if (userInfos == null || userInfos.isEmpty())
                    return;

                for (final UserInfo item : userInfos) {
                    usersAdapter.add(item, UserDataBinder.class);
                }
            }
        });
    }

    private void setupRecyclerView() {
        usersList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        usersList.addItemDecoration(new SpacesItemDecoration(2));
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
