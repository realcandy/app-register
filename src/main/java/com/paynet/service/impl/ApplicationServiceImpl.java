package com.paynet.service.impl;

import com.paynet.entity.Application;
import com.paynet.repository.ApplicationRepository;
import com.paynet.repository.CommentRepository;
import com.paynet.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application save(Application application) {
        applicationRepository.insert(application);
        return applicationRepository.findOne(application);
    }

    @Override
    public Application update(Application application) {
        applicationRepository.update(application);
        return applicationRepository.findOne(application);
    }

    @Override
    public Application find(Application application) {
        return applicationRepository.findOne(application);
    }

    @Override
    public void delete(Application application) {
        applicationRepository.delete(application);
    }
}
