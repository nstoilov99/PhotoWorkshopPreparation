package com.example.app.model.dto.json.photographersWithSameCameras;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerXMLExportDto {

    @XmlTransient
    private String firstName;

    @XmlTransient
    private String lastName;

    @XmlTransient
    private String primaryCameraMake;

    @XmlTransient
    private String primaryCameraModel;

    @XmlElementWrapper(name = "lenses")
    @XmlElement(name = "lens")
    private List<LensExportXMLDto> lenses;

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

    public String getPrimaryCameraMake() {
        return this.primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public String getPrimaryCameraModel() {
        return this.primaryCameraModel;
    }

    public void setPrimaryCameraModel(String primaryCameraModel) {
        this.primaryCameraModel = primaryCameraModel;
    }

    public List<LensExportXMLDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<LensExportXMLDto> lenses) {
        this.lenses = lenses;
    }

    @XmlAttribute(name = "name")
    public String getFullName(){
        return firstName + " " + lastName;
    }

    @XmlAttribute(name = "primary-camera")
    public String getPrimaryCamera(){
        return primaryCameraMake + " " + primaryCameraModel;
    }
}
