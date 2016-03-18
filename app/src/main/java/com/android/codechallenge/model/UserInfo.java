package com.android.codechallenge.model;
import android.support.annotation.NonNull;
import com.common.android.utils.logging.Logger;
import com.google.gson.annotations.SerializedName;
import com.orhanobut.wasp.WaspError;

import static com.common.android.utils.misc.GsonProvider.getGson;

public class UserInfo {
    @SerializedName("fname")
    public String firstName;

    @SerializedName("lname")
    public String lastName;

    @SerializedName("gender")
    public String gender;

    @SerializedName("dob")
    public String dateOfBirth;

    @SerializedName("__v")
    public int version;

    @SerializedName("_id")
    public String userId;

    public static final String TAG = UserInfo.class.getSimpleName();

    public UserInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserInfo setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserInfo setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @NonNull
    public synchronized static UserResponseModel from(final WaspError waspError) {
        UserResponseModel error = new UserResponseModel();
        try {
            error = getGson().fromJson(waspError.getResponse().getBody(), UserResponseModel.class);

            if (error == null)
                Logger.e(TAG, waspError.toString());

        } catch (Exception e) {
            e.printStackTrace();
            waspError.getResponse().getBody();
        } finally {
            if (error == null)
                error = new UserResponseModel();
        }
        if (waspError.getResponse() != null)
            waspError.getResponse().getStatusCode();
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (version != userInfo.version) return false;
        if (firstName != null ? !firstName.equals(userInfo.firstName) : userInfo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userInfo.lastName) : userInfo.lastName != null) return false;
        if (gender != null ? !gender.equals(userInfo.gender) : userInfo.gender != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(userInfo.dateOfBirth) : userInfo.dateOfBirth != null)
            return false;
        return userId != null ? userId.equals(userInfo.userId) : userInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", version=" + version +
                ", userId='" + userId + '\'' +
                '}';
    }
}