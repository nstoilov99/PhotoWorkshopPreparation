package com.example.app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.entities.BasicCamera;

@Repository
public interface BasicCameraRepository extends JpaRepository<BasicCamera,Long> {
}