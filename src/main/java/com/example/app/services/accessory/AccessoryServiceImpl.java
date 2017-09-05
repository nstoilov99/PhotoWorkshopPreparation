package com.example.app.services.accessory;

import com.example.app.model.entities.Accessory;
import com.example.app.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService {

	private final AccessoryRepository accessoryRepository;

	@Autowired
	public AccessoryServiceImpl(AccessoryRepository accessoryRepository) { 
		this.accessoryRepository = accessoryRepository;
	}

    @Override
    public List<Accessory> addAll(Iterable<Accessory> accessories) {
        return accessoryRepository.save(accessories);
    }
}