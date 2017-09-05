package com.example.app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.entities.Accessory;

import java.util.List;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long> {
}