package com.example.app.model.dto.json.photographersWithSameCameras;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class LensExportXMLDto {

    @XmlTransient
    private String make;

    @XmlTransient
    private Integer focalLength;

    @XmlTransient
    private Double maxAperture;

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

    @XmlValue
    public String getDesc(){
        return make + " " + focalLength + "mm f" + maxAperture;
    }
}
