package com.example.app.services.basicCamera;

import com.example.app.model.entities.BasicCamera;
import com.example.app.model.parsers.util.ValidationUtil;
import com.example.app.repositories.BasicCameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BasicCameraServiceImpl implements BasicCameraService {

    private final BasicCameraRepository basicCameraRepository;

    @Autowired
    public BasicCameraServiceImpl(BasicCameraRepository basicCameraRepository) {
        this.basicCameraRepository = basicCameraRepository;
    }

    @Override
    public BasicCamera add(BasicCamera camera) {
        BasicCamera persistedCamera = null;
        if (ValidationUtil.isValid(camera)) {
            persistedCamera = basicCameraRepository.save(camera);
            System.out.println("Successfully imported " + camera);
        } else {
            System.out.println("Error. Invalid data provided");
        }
        return persistedCamera;
    }
}