package com.android.codechallenge.model;

import java.util.List;

/**
 * Created by greymatter on 17/03/16.
 */
public class UserResponseModel {

    public List<UserInfo> userInfoList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResponseModel that = (UserResponseModel) o;

        return userInfoList != null ? userInfoList.equals(that.userInfoList) : that.userInfoList == null;

    }

    @Override
    public int hashCode() {
        return userInfoList != null ? userInfoList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserResponseModel{" +
                "userInfoList=" + userInfoList +
                '}';
    }
}
