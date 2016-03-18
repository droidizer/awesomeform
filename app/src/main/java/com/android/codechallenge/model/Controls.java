package com.android.codechallenge.model;

import com.google.gson.annotations.SerializedName;

public class Controls {

    @SerializedName("response")
    private java.util.List<Response> response;

    @SerializedName("action")
    private String action;

    @SerializedName("caption")
    private String caption;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Controls controls = (Controls) o;

        if (response != null ? !response.equals(controls.response) : controls.response != null) return false;
        if (action != null ? !action.equals(controls.action) : controls.action != null) return false;
        return caption != null ? caption.equals(controls.caption) : controls.caption == null;

    }

    @Override
    public int hashCode() {
        int result = response != null ? response.hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Controls{" +
                "response=" + response +
                ", action='" + action + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}

