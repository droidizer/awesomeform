package com.android.codechallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by greymatter on 17/03/16.
 */
public class Fields {

        @SerializedName("fieldName")
        private String fieldName;

        @SerializedName("fieldCaption")
        private String fieldCaption;

        @SerializedName("fieldType")
        private String fieldType;

       @SerializedName("validation")
        private List<Validation> validation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fields fields = (Fields) o;

        if (fieldName != null ? !fieldName.equals(fields.fieldName) : fields.fieldName != null) return false;
        if (fieldCaption != null ? !fieldCaption.equals(fields.fieldCaption) : fields.fieldCaption != null)
            return false;
        if (fieldType != null ? !fieldType.equals(fields.fieldType) : fields.fieldType != null) return false;
        return validation != null ? validation.equals(fields.validation) : fields.validation == null;

    }

    @Override
    public int hashCode() {
        int result = fieldName != null ? fieldName.hashCode() : 0;
        result = 31 * result + (fieldCaption != null ? fieldCaption.hashCode() : 0);
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        result = 31 * result + (validation != null ? validation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldCaption='" + fieldCaption + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", validation=" + validation +
                '}';
    }
}
