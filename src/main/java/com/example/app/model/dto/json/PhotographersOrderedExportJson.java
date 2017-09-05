package com.example.app.model.dto.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotographersOrderedExportJson {
    @Expose
    @SerializedName("FirstName")
    private String firstName;

    @Expose
    @SerializedName("LastName")
    private String lastName;

    @Expose
    @SerializedName("Phone")
    private String phone;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
