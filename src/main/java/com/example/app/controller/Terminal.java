package com.example.app.controller;

import com.example.app.model.dto.json.CameraImportJsonDto;
import com.example.app.model.dto.json.LensImportJsonDto;
import com.example.app.model.dto.json.PhotographersImportJsonDto;
import com.example.app.model.dto.json.PhotographersOrderedExportJson;
import com.example.app.model.dto.json.photographersWithSameCameras.PhotographerXMLExportDto;
import com.example.app.model.dto.json.photographersWithSameCameras.PhotographersXMLExportDto;
import com.example.app.model.dto.xml.accessories.AccessoriesXMLImportDto;
import com.example.app.model.dto.xml.workshops.WorkshopXMLImportDto;
import com.example.app.model.dto.xml.workshops.WorkshopsXMLImportDto;
import com.example.app.model.entities.*;
import com.example.app.model.parsers.JsonParser;
import com.example.app.model.parsers.XMLParser;
import com.example.app.model.parsers.util.MappingUtil;
import com.example.app.services.accessory.AccessoryService;
import com.example.app.services.basicCamera.BasicCameraService;
import com.example.app.services.lens.LensService;
import com.example.app.services.photographer.PhotographerService;
import com.example.app.services.workshop.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {
    private final String LENSES_INPUT_JSON = "/files/json/input/lenses.json";
    private final String CAMERAS_INPUT_JSON = "/files/json/input/cameras.json";
    private final String PHOTOGRAPHERS_INPUT_JSON = "/files/json/input/photographers.json";
    private final String ACCESSORIES_INPUT_XML = "/files/xml/input/accessories.xml";
    private final String WORKSHOPS_INPUT_XML = "/files/xml/input/workshops.xml";
    private final String PHOTOGRAPHERS_OUTPUT_JSON = "src/main/resources/files/json/output/photographersOrdered.json";
    private final String PHOTOGRAPHERS_SAME_CAMERA_OUTPUT_XML = "src/main/resources/files/xml/output/photographersSameCamera.xml";

    private final JsonParser jsonParser;
    private final XMLParser xmlParser;
    private final LensService lensService;
    private final BasicCameraService basicCameraService;
    private final PhotographerService photographerService;
    private final AccessoryService accessoryService;
    private final WorkshopService workshopService;

    @Autowired
    public Terminal(JsonParser jsonParser, XMLParser xmlParser, LensService lensService, BasicCameraService basicCameraService, PhotographerService photographerService, AccessoryService accessoryService, WorkshopService workshopService) {
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.lensService = lensService;
        this.basicCameraService = basicCameraService;
        this.photographerService = photographerService;
        this.accessoryService = accessoryService;
        this.workshopService = workshopService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        importLensesJson();
//        importCamerasJson();
//        importPhotographersJson();
//        importAccessoriesXML();
//        importWorkshopsXML();
//        exportPhotographersOrderJson();
        exportPhotographersWithSameCamerasXML();
    }

    private void exportPhotographersWithSameCamerasXML() throws IOException, JAXBException {
        List<Photographer> allWithSameCameras = photographerService.findAllWithSameCameras();
        List<PhotographerXMLExportDto> photographers = MappingUtil.convert(allWithSameCameras, PhotographerXMLExportDto.class);
        PhotographersXMLExportDto photographersXMLExportDto = new PhotographersXMLExportDto();
        photographersXMLExportDto.setPhotographerXMLExportDtos(photographers);
        for (PhotographerXMLExportDto photographer : photographers) {
            if (photographer.getLenses().size()==0){
                photographer.setLenses(null);
            }
        }
        xmlParser.writeObject(photographersXMLExportDto,PHOTOGRAPHERS_SAME_CAMERA_OUTPUT_XML);
    }

    private void exportPhotographersOrderJson() throws IOException {
        List<Photographer> allOrdered = photographerService.findAllOrdered();
        List<PhotographersOrderedExportJson> photographers = MappingUtil.convert(allOrdered, PhotographersOrderedExportJson.class);
        jsonParser.writeObject(photographers, PHOTOGRAPHERS_OUTPUT_JSON);
    }

    private void importWorkshopsXML() throws JAXBException, IOException {
        WorkshopsXMLImportDto workshopsDto = xmlParser.getObject(WorkshopsXMLImportDto.class, WORKSHOPS_INPUT_XML);
        for (WorkshopXMLImportDto workshopXMLImportDto : workshopsDto.getWorkshopXMLImportDtos()) {
            Workshop workshop = MappingUtil.convert(workshopXMLImportDto, Workshop.class);
            workshopService.addWorkshop(workshop);
        }
    }

    private void importAccessoriesXML() throws JAXBException, IOException {
        AccessoriesXMLImportDto accessoriesDto = xmlParser.getObject(AccessoriesXMLImportDto.class, ACCESSORIES_INPUT_XML);
        List<Accessory> accessories = MappingUtil.convert(accessoriesDto.getAccessoriesXMLImportDtos(),Accessory.class);
        accessoryService.addAll(accessories);

    }

    private void importPhotographersJson() {
        PhotographersImportJsonDto[] photographersDtos = jsonParser.getObject(PhotographersImportJsonDto[].class, PHOTOGRAPHERS_INPUT_JSON);
        for (PhotographersImportJsonDto photographersDto : photographersDtos) {
            Photographer photographer = MappingUtil.convert(photographersDto,Photographer.class);
            photographerService.addPhotographer(photographer, photographersDto.getLenses());
        }

    }

    private void importCamerasJson() {
        CameraImportJsonDto[] cameraDtos = jsonParser.getObject(CameraImportJsonDto[].class, CAMERAS_INPUT_JSON);
        for (CameraImportJsonDto cameraDto : cameraDtos) {
            BasicCamera basicCamera = null;
            if ("DSLR".equals(cameraDto.getType())){
                basicCamera = MappingUtil.convert(cameraDto,DSLRCamera.class);
                basicCameraService.add(basicCamera);
            } else if ("Mirrorless".equals(cameraDto.getType())) {
                basicCamera = MappingUtil.convert(cameraDto,MirrorlessCamera.class);
                basicCameraService.add(basicCamera);
            }
        }
    }

    private void importLensesJson() {
        LensImportJsonDto[] lensDtos = jsonParser.getObject(LensImportJsonDto[].class, LENSES_INPUT_JSON);
        List<Lens> lenses = MappingUtil.convert(Arrays.asList(lensDtos),Lens.class);
        lensService.addAll(lenses);
    }
}