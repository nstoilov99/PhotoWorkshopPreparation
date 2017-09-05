package com.example.app.services.lens;

import com.example.app.model.entities.Lens;

import java.util.List;

public interface LensService {
    List<Lens> addAll(Iterable<Lens> lenses);
    List<Lens> findByIdIn(Iterable<Long> id);
}