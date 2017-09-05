package com.example.app.model.dto.json;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;

public class LensImportJsonDto {

    @Expose
    private String make;

    @Expose
    private Integer focalLength;

    @Expose
    private Double maxAperture;

    @Expose
    private String compatibleWith;

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return this.compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
