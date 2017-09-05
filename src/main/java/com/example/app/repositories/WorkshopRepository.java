package com.example.app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.entities.Workshop;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop,Long> {


}