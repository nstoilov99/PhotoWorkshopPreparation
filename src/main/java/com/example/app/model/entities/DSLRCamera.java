package com.example.app.model.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends BasicCamera {
    @Column(name = "max_shutter_speed")
    private Integer maxShutterSpeed;

    public Integer getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String type() {
        return "DSLR";
    }
}
