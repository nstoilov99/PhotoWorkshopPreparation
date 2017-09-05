package com.example.app.services.workshop;

import com.example.app.model.entities.Photographer;
import com.example.app.model.entities.Workshop;
import com.example.app.model.parsers.util.ValidationUtil;
import com.example.app.repositories.PhotographerRepository;
import com.example.app.repositories.WorkshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;
    private PhotographerRepository photographerRepository;

    public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public Workshop addWorkshop(Workshop workshop) {
        Workshop persistedWorkshop = null;
        if (ValidationUtil.isValid(workshop)) {
            Photographer trainer = photographerRepository.findByFirstNameAndLastName(workshop.getTrainer().getFirstName(), workshop.getTrainer().getLastName());
            workshop.setTrainer(trainer);

            Set<Photographer> participants = new HashSet<>();
            if (workshop.getParticipants() != null) {
                for (Photographer photographer : workshop.getParticipants()) {
                    Photographer participant = photographerRepository.findByFirstNameAndLastName(photographer.getFirstName(), photographer.getLastName());
                    participants.add(participant);
                }
                workshop.setParticipants(participants);
            }

            if (ValidationUtil.isValid(workshop)) {
                persistedWorkshop = workshopRepository.save(workshop);
                System.out.println("Successfully imported " + workshop.getName());
            } else {
                System.out.println("Error. Invalid data provided");
            }
        } else {
            System.out.println("Error. Invalid data provided");
        }
        return persistedWorkshop;
    }
}