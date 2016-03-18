package com.android.codechallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonalInfoForm {

    @SerializedName("formID")
    private String id;

    @SerializedName("formType")
    private String type;

    @SerializedName("formSubTitle")
    private String subTitle;

    @SerializedName("controls")
    private List<Controls> controls;

    @SerializedName("title")
    private String title;

    @SerializedName("fields")
    private List<Fields> fields;

    public PersonalInfoForm setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public PersonalInfoForm setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalInfoForm that = (PersonalInfoForm) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (subTitle != null ? !subTitle.equals(that.subTitle) : that.subTitle != null) return false;
        if (controls != null ? !controls.equals(that.controls) : that.controls != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (subTitle != null ? subTitle.hashCode() : 0);
        result = 31 * result + (controls != null ? controls.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalInfoForm{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", controls=" + controls +
                ", title='" + title + '\'' +
                ", fields=" + fields +
                '}';
    }
}
