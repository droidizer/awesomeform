package com.android.codechallenge.ui.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.android.codechallenge.R;
import com.android.codechallenge.model.UserInfo;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.common.android.utils.ui.recyclerView.DataBinder;
import org.jetbrains.annotations.NotNull;

public class UserDataBinder extends DataBinder<UserInfo, UserDataBinder.ViewHolder> {

    public UserDataBinder(@NotNull DataBindAdapter<UserInfo> dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public void bindViewHolder(@NotNull ViewHolder viewHolder, int position) {
        final UserInfo item = get(position);

        viewHolder.name.setText(item.firstName + " " + item.lastName);
        viewHolder.gender.setText(item.gender);
        viewHolder.dob.setText(item.dateOfBirth);
    }

    @Override
    public int getLayout() {
        return R.layout.user_item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        @Bind(R.id.name)
        TextView name;
        @NonNull
        @Bind(R.id.gender)
        TextView gender;
        @NonNull
        @Bind(R.id.dob)
        TextView dob;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
