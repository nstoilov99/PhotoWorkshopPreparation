package com.example.app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.entities.Lens;

import java.util.List;

@Repository
public interface LensRepository extends JpaRepository<Lens,Long> {
    List<Lens> findByIdIn(Iterable<Long> id);
}