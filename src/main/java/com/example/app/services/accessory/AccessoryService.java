package com.example.app.services.accessory;

import com.example.app.model.entities.Accessory;

import java.util.List;

public interface AccessoryService {
    List<Accessory> addAll(Iterable<Accessory> accessories);
}