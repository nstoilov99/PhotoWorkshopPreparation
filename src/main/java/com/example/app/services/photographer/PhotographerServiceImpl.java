package com.example.app.services.photographer;

import com.example.app.model.entities.BasicCamera;
import com.example.app.model.entities.Lens;
import com.example.app.model.entities.Photographer;
import com.example.app.model.parsers.util.ValidationUtil;
import com.example.app.repositories.BasicCameraRepository;
import com.example.app.repositories.LensRepository;
import com.example.app.repositories.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

    private final PhotographerRepository photographerRepository;
    private final LensRepository lensRepository;
    private final BasicCameraRepository basicCameraRepository;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository, LensRepository lensRepository, BasicCameraRepository basicCameraRepository) {
        this.photographerRepository = photographerRepository;
        this.lensRepository = lensRepository;
        this.basicCameraRepository = basicCameraRepository;
    }

    @Override
    public Photographer addPhotographer(Photographer photographer, Iterable<Long> lensIds) {
        addCamera(photographer);
        Photographer persistedPhotographer = null;
        if (ValidationUtil.isValid(photographer)) {
            List<Lens> lenses = lensRepository.findByIdIn(lensIds);
            List<Lens> resultList = new ArrayList<>();
            for (Lens lense : lenses) {
                lense.setOwner(photographer);
                if (isCompatible(lense, photographer.getPrimaryCamera()) ||
                        isCompatible(lense,photographer.getSecondaryCamera())){
                    lense.setOwner(photographer);
                    resultList.add(lense);
                } else {
                    System.out.println("Lense Is Not Compatible SORRY !!!");
                }
            }
            photographer.setLenses(resultList);
            persistedPhotographer = photographerRepository.save(photographer);
            System.out.println("Successfully imported " + photographer);
        } else {
            System.out.println("Error. Invalid data provided");
        }
        return persistedPhotographer;
    }

    @Override
    public List<Photographer> findAllOrdered() {
        return photographerRepository.findAllOrdered();
    }

    @Override
    public List<Photographer> findAllWithSameCameras() {
        return photographerRepository.findAllWithSameCameras();
    }

    private void addCamera(Photographer photographer) {
        Long count = basicCameraRepository.count();
        Random random = new Random();
        Long id = ThreadLocalRandom.current().nextLong(1, count);
        if (photographer.getPrimaryCamera() == null) {
            photographer.setPrimaryCamera(basicCameraRepository.findOne(id));
        }

        id = ThreadLocalRandom.current().nextLong(1, count);
        if (photographer.getSecondaryCamera() == null) {
            photographer.setSecondaryCamera(basicCameraRepository.findOne(id));
        }
    }

    private boolean isCompatible(Lens lens, BasicCamera camera){
        return  lens.getCompatibleWith() != null && lens.getCompatibleWith().equals(camera.getMake());
    }

}