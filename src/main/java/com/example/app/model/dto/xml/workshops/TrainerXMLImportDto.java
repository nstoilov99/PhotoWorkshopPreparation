package com.example.app.model.dto.xml.workshops;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrainerXMLImportDto {

    @XmlTransient
    private String firstName;

    @XmlTransient
    private String lastName;

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

    @XmlValue
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName){
        String[] names = fullName.split("\\s+");
        this.firstName = names[0];
        this.lastName = names[1];
    }
}
