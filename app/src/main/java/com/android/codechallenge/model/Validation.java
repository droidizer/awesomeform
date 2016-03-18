package com.android.codechallenge.model;

import com.google.gson.annotations.SerializedName;

public class Validation {
    @SerializedName("validationName")
    private String validationName;

    @SerializedName("minLength")
    private int minLength;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("maxLength")
    private int maxLength;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Validation that = (Validation) o;

        if (minLength != that.minLength) return false;
        if (maxLength != that.maxLength) return false;
        if (validationName != null ? !validationName.equals(that.validationName) : that.validationName != null)
            return false;
        return errorMessage != null ? errorMessage.equals(that.errorMessage) : that.errorMessage == null;

    }

    @Override
    public int hashCode() {
        int result = validationName != null ? validationName.hashCode() : 0;
        result = 31 * result + minLength;
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        result = 31 * result + maxLength;
        return result;
    }

    @Override
    public String toString() {
        return "Validation{" +
                "validationName='" + validationName + '\'' +
                ", minLength=" + minLength +
                ", errorMessage='" + errorMessage + '\'' +
                ", maxLength=" + maxLength +
                '}';
    }
}

