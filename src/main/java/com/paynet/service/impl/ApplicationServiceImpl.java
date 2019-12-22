package com.paynet.service.impl;

import com.paynet.entity.Application;
import com.paynet.repository.ApplicationRepository;
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
        return applicationRepository.getApplications();
    }

    @Override
    public Application save(Application application) {
        applicationRepository.insertApplication(application);
        return applicationRepository.findApplication(application);
    }

    @Override
    public Application update(Application application) {
        applicationRepository.updateApplication(application);
        return applicationRepository.findApplication(application);
    }
}
