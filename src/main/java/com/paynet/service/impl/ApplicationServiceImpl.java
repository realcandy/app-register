package com.paynet.service.impl;

import com.paynet.aspect.AuthorizeAction;
import com.paynet.entity.Application;
import com.paynet.repository.ApplicationRepository;
import com.paynet.service.ApplicationService;
import com.paynet.service.UserService;
import com.paynet.util.SecurityContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @AuthorizeAction
    @Transactional
    @Override
    public Application save(Application application) {
        application.setDateCreate(new Date());
        application.setUser(userService.findUserByLogin(SecurityContextUtils.getUsername()));
        applicationRepository.insert(application);
        return applicationRepository.findOne(application);
    }

    @AuthorizeAction
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
