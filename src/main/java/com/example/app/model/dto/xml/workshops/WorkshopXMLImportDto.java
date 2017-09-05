package com.example.app.model.dto.xml.workshops;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopXMLImportDto {

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "start_date")
    private Date startDate;

    @XmlAttribute(name = "end_date")
    private Date endDate;

    @XmlAttribute
    private String location;

    @XmlAttribute(name = "price")
    private Double pricePerParticipant;

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    private List<ParticipantXMLImportDto> participants;

    @XmlElement(name = "trainer")
    private TrainerXMLImportDto trainer;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(Double pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public List<ParticipantXMLImportDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantXMLImportDto> participants) {
        this.participants = participants;
    }

    public TrainerXMLImportDto getTrainer() {
        return this.trainer;
    }

    public void setTrainer(TrainerXMLImportDto trainer) {
        this.trainer = trainer;
    }
}
