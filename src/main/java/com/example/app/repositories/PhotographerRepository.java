package com.example.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.entities.Photographer;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long> {
    Photographer findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT p FROM Photographer AS p ORDER BY p.firstName ASC, p.lastName DESC")
    List<Photographer> findAllOrdered();

    @Query(value = "SELECT p FROM Photographer AS p WHERE p.primaryCamera.make =p.secondaryCamera.make")
    List<Photographer> findAllWithSameCameras();
}