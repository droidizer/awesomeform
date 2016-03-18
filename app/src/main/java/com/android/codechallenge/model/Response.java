package com.android.codechallenge.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("resposeType")
    private String responseType;

    @SerializedName("message")
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (responseType != null ? !responseType.equals(response.responseType) : response.responseType != null)
            return false;
        return message != null ? message.equals(response.message) : response.message == null;

    }

    @Override
    public int hashCode() {
        int result = responseType != null ? responseType.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseType='" + responseType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
