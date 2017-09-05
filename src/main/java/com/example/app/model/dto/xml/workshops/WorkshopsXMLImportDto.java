package com.example.app.model.dto.xml.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsXMLImportDto {

    @XmlElement(name = "workshop")
    private List<WorkshopXMLImportDto> workshopXMLImportDtos;

    public List<WorkshopXMLImportDto> getWorkshopXMLImportDtos() {
        return this.workshopXMLImportDtos;
    }

    public void setWorkshopXMLImportDtos(List<WorkshopXMLImportDto> workshopXMLImportDtos) {
        this.workshopXMLImportDtos = workshopXMLImportDtos;
    }
}
