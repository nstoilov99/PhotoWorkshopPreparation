package com.example.app.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mirrorless")
public class MirrorlessCamera extends BasicCamera {
    @Column(name = "max_video_resolution")
    private String maxVideoResoltion;

    @Column(name = "max_frame_rate")
    private String maxFrameRate;

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

    @Override
    protected String type() {
        return "Mirrorless";
    }
}
