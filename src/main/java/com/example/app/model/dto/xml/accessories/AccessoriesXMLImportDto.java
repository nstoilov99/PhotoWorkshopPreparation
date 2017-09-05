package com.example.app.model.dto.xml.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesXMLImportDto {

    @XmlElement(name = "accessory")
    private List<AccessoriesXMLImportDto> accessoriesXMLImportDtos;

    public List<AccessoriesXMLImportDto> getAccessoriesXMLImportDtos() {
        return this.accessoriesXMLImportDtos;
    }

    public void setAccessoriesXMLImportDtos(List<AccessoriesXMLImportDto> accessoriesXMLImportDtos) {
        this.accessoriesXMLImportDtos = accessoriesXMLImportDtos;
    }
}
