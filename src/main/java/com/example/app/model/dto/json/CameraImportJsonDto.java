package com.example.app.model.dto.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Basic;
import javax.persistence.Column;

public class CameraImportJsonDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private boolean isFullFrame;

    @Expose
    private Integer minISO;

    @Expose
    private Integer maxISO;

    @Expose
    @SerializedName(value = "MaxShutterSpeed")
    private Integer maxShutterSpeed;

    @Expose
    private String maxVideoResoltion;

    @Expose
    private String maxFrameRate;

    @Expose
    private String type;

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return this.isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public Integer getMinISO() {
        return this.minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    public Integer getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

    public Integer getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResoltion() {
        return this.maxVideoResoltion;
    }

    public void setMaxVideoResoltion(String maxVideoResoltion) {
        this.maxVideoResoltion = maxVideoResoltion;
    }

    public String getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(String maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
