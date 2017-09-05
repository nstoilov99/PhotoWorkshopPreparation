package com.example.app.services.photographer;

import com.example.app.model.entities.Photographer;

import java.util.List;

public interface PhotographerService {
    Photographer addPhotographer(Photographer photographer,Iterable<Long> lensIds);
    List<Photographer> findAllOrdered();
    List<Photographer> findAllWithSameCameras();
}