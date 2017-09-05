package com.example.app.model.dto.json.photographersWithSameCameras;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographersXMLExportDto {

    @XmlElement(name = "photographer")
    List<PhotographerXMLExportDto> photographerXMLExportDtos;

    public List<PhotographerXMLExportDto> getPhotographerXMLExportDtos() {
        return this.photographerXMLExportDtos;
    }

    public void setPhotographerXMLExportDtos(List<PhotographerXMLExportDto> photographerXMLExportDtos) {
        this.photographerXMLExportDtos = photographerXMLExportDtos;
    }
}
